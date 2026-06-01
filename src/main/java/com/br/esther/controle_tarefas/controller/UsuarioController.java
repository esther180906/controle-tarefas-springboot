// Controller responsável por receber as requisições relacionadas aos usuários
// e encaminhá-las para a camada de serviço.

package com.br.esther.controle_tarefas.controller;

import com.br.esther.controle_tarefas.model.Usuario;
import com.br.esther.controle_tarefas.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import com.br.esther.controle_tarefas.dto.UsuarioDTO;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario salvar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());

        return usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id,
                             @RequestBody @Valid UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());

        return usuarioService.atualizar(id, usuario);
    }
}

