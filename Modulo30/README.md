Exercicios do Modulo30
Estarei recriando do 0, de uma forma lógica e adicionando comentarios

Como se trata de um CRUD
CREAT
READ
UPDATE
DELETE

Eu acredito que o primeiro passo seja criarmos e testarmos a conexao com banco de dados

Logo depois nos podemos criar nossa classe modelo. no nosso caso vamos criar no pacote domain

logo depois podemos criar o DAO. que seria o acesso ao dado, mas antes vamos criar as interfacesDAO


// Estrutura do projeto Modulo30
// 1. com.kaio.generic.factory - Gerenciamento de conexões
// 2. com.kaio.model - Representação das entidades
// 3. com.kaio.dao - Acesso aos dados
// 4. com.kaio.services - Lógica de negócios
// 5. com.kaio.main - Ponto de entrada da aplicação

Aqui vou descrever a sequencia logica para a criacao de um CRUD. 
1. primeiro voce cria a conexao com o banco / cria o banco e as tabelas 
    -- no meu caso eu criei dois containers no docker, um para producao e outro para testes
    -- os dados de acesso eu usei para criar uma conexao de teste
--Usei um "script" o docker-compose.yml
--Usei os dados para criar o ConnectionFactory

2. Segundo voce cria as classes principais ou models ou domain..
    -- No meu caso eu criei 
        -- Cliente, Venda, Produto, ProdutoQuantidade, Estoque

   3. Terceiro voce parte para o DAO ou REPOSITORY
      -- Vou criar DAO entao o (ClienteDAO extends GenericDAO implements IclienteDAO)
                                                   GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T,E>
         3.1 -- Vamos para a interface que é o contrato a ser seguido
                   IClienteDAO extends IGenericDAO<Cliente, Long>
                                       IGenericDAO <T extends Persistente, E extends Serializable>
   
      public interface Persistente {

      //public Long getCodigo();

      public Long getId();

      public void setId(Long id);
      }
para ter um fraco acoplamento vamos criar GenericDAO e IGenericDAO
partindo do mesmo principio de dao e interface


tentativa de explicar o codigo. primeiro vc inicia pela classe ou interface

1 interface / classe 
na classe vc determina os parametros, os atributos, 
na interface vc determina os metodos, ou acoes, oque vc vai fazer com os atributos da classe

2 dao
para um fraco acoplamento vamos criar os dao generic e a interfaces generics...
No dao como se trata de acesso ao banco atraves de consultas, gera exceptions, 
entao quando for fazer o dao podemos iniciar pelas exceptions quando for pedido



































