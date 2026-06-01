package com.br.esther.controle_tarefas.repository;

import com.br.esther.controle_tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}

// Interface responsável pelas operações de banco de dados da entidade Tarefa.