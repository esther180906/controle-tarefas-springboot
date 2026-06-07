package com.br.esther.controle_tarefas.repository;

import com.br.esther.controle_tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByStatus(String status);
}

// Interface responsável pelas operações de banco de dados da entidade Tarefa.