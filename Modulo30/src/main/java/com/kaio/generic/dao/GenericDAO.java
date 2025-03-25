package com.kaio.generic.dao;


import com.kaio.domain.Cliente;
import com.kaio.exceptions.DAOException;
import com.kaio.exceptions.TipoChaveNaoEncontradaException;
import com.kaio.interfaces.Persistente;
import com.kaio.interfaces.dao.IGenericDAO;

import java.io.Serializable;
import java.sql.*;

import static com.kaio.generic.jdbc.ConnectionFactory.getConnection;

public abstract class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T,E> {

    public abstract Class<T> getTipoClasse();

    public abstract void atualizarDados(T entity, T entityCadastrado);

    protected abstract String getQueryInsercao();

    protected abstract void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException;

    protected abstract String getQueryExclusao();

    protected abstract String getQueryAtualizacao();

    protected abstract void setParametrosQueryInsercao(PreparedStatement stmInsert, T entity) throws SQLException;

    protected abstract void setParametrosQueryExclusao(PreparedStatement stmDelete, E valor) throws SQLException;

    protected abstract void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, T entity) throws SQLException;

    protected abstract void setParametrosQuerySelect(PreparedStatement stmUpdate, E valor) throws SQLException;

    public GenericDAO() {

    }

    public E getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();
        E returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    returnValue = (E) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    //Criar exception de negócio TipoChaveNaoEncontradaException
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradaException("Chave principal do objeto " + entity.getClass() + " não encontrada", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
            System.out.println("**** ERRO ****" + msg);
            throw new TipoChaveNaoEncontradaException(msg);
        }
        return null;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(getQueryInsercao(), Statement.RETURN_GENERATED_KEYS);
            setParametrosQueryInsercao(stm, entity);
            int rowsAffected = stm.executeUpdate();

            if(rowsAffected > 0) {
                try (ResultSet rs = stm.getGeneratedKeys()){
                    if (rs.next()) {
                        Persistente per = (Persistente) entity;
                        per.setId(rs.getLong(1));
                    }
                }
                return true;
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO CADASTRANDO OBJETO ", e);
        } finally {
            closeConnection(connection, stm, null);
        }
        return false;
    }


    @Override
    public void excluir(E valor) throws DAOException {
        Connection connection = getConnection();
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(getQueryExclusao());
            setParametrosQueryExclusao(stm, valor);
            int rowsAffected = stm.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("ERRO EXCLUINDO OBJETO ", e);
        } finally {
            closeConnection(connection, stm, null);
        }

    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {

        Connection connection = getConnection();
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(getQueryAtualizacao());
            setParametrosQueryAtualizacao(stm, entity);
            int rowsAffected = stm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("ERRO ALTERANDO OBJETO ", e);
        } finally {
            closeConnection(connection, stm, null);
        }

    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        try {
            validarMaisDeUmRegistro(valor);
            Connection connection = getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM " + getTableName() + " WHERE " + getNomeCampoChave(getTipoClasse()) + " = ?");
            setParametrosQuerySelect(stm, valor);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                T entity = getTipoClasse().getConstructor(null).newInstance(null);
                Field[] fields = entity.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(ColunaTabela.class)) {
                        ColunaTabela coluna = field.getAnnotation(ColunaTabela.class);
                        String dbName = coluna.dbName();
                        String javaSetName = coluna.setJavaName();
                        Class<?> classField = field.getType();
                        try {
                            Method method = entity.getClass().getMethod(javaSetName, classField);
                            setValueByType(entity, method, classField, rs, dbName);

                        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
                        } catch (TipoElementoNaoConhecidoException e) {
                            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
                        }
                    }
                }
                return entity;
            }
