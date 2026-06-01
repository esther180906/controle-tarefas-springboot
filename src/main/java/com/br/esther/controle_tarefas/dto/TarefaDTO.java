package com.br.esther.controle_tarefas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// DTO responsável por receber e validar os dados de tarefa enviados na API.
public class TarefaDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 3, message = "O título deve ter no mínimo 3 caracteres")
    private String titulo;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    private String descricao;

    @NotBlank(message = "O status é obrigatório")
    private String status;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long usuarioId;

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
}