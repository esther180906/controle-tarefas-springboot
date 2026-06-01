package com.br.esther.controle_tarefas.repository;

import com.br.esther.controle_tarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

// Interface responsável pelas operações de banco de dados da entidade Usuario.