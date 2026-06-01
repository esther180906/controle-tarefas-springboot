// Camada responsável pelas regras de negócio relacionadas aos usuários.

package com.br.esther.controle_tarefas.service;

import com.br.esther.controle_tarefas.model.Usuario;
import com.br.esther.controle_tarefas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import com.br.esther.controle_tarefas.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizar(Long id, Usuario usuario) {

        Usuario usuarioExistente = buscarPorId(id);

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());

        return usuarioRepository.save(usuarioExistente);
    }
}


