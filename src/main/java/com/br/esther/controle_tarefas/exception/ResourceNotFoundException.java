package com.br.esther.controle_tarefas.exception;

// Exceção lançada quando um recurso não é encontrado no sistema.
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}