package com.kaio.exception;

public class TipoElementoNaoConhecidoException extends RuntimeException {
    public TipoElementoNaoConhecidoException(String message) {
        super(message);
    }
}
