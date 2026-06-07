package com.br.esther.controle_tarefas.controller;

import com.br.esther.controle_tarefas.dto.UsuarioDTO;
import com.br.esther.controle_tarefas.model.Usuario;
import com.br.esther.controle_tarefas.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável por receber as requisições relacionadas aos usuários
// e encaminhá-las para a camada de serviço.

@Tag(name = "Usuários", description = "Endpoints para gerenciamento de usuários")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Cadastrar usuário", description = "Cria um novo usuário.")
    @PostMapping
    public Usuario salvar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());

        return usuarioService.salvar(usuario);
    }

    @Operation(summary = "Listar usuários", description = "Retorna todos os usuários cadastrados.")
    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @Operation(summary = "Buscar usuário por ID", description = "Busca um usuário específico pelo ID.")
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @Operation(summary = "Deletar usuário", description = "Remove um usuário pelo ID.")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados de um usuário existente.")
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id,
                             @RequestBody @Valid UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());

        return usuarioService.atualizar(id, usuario);
    }
}