package com.br.esther.controle_tarefas.service;

import com.br.esther.controle_tarefas.exception.ResourceNotFoundException;
import com.br.esther.controle_tarefas.model.Usuario;
import com.br.esther.controle_tarefas.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Testes unitários da camada de serviço de usuários.
@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void deveSalvarUsuarioComSucesso() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Esther");
        usuario.setEmail("esther@email.com");

        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario resultado = usuarioService.salvar(usuario);

        assertNotNull(resultado);
        assertEquals("Esther", resultado.getNome());
        assertEquals("esther@email.com", resultado.getEmail());

        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void deveListarTodosUsuarios() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Esther");
        usuario.setEmail("esther@email.com");

        when(usuarioRepository.findAll()).thenReturn(List.of(usuario));

        List<Usuario> resultado = usuarioService.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals("Esther", resultado.get(0).getNome());

        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void deveBuscarUsuarioPorIdComSucesso() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Esther");
        usuario.setEmail("esther@email.com");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Esther", resultado.getNome());

        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoForEncontrado() {
        when(usuarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            usuarioService.buscarPorId(99L);
        });

        verify(usuarioRepository, times(1)).findById(99L);
    }

    @Test
    void deveAtualizarUsuarioComSucesso() {
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setId(1L);
        usuarioExistente.setNome("Esther");
        usuarioExistente.setEmail("antigo@email.com");

        Usuario usuarioAtualizado = new Usuario();
        usuarioAtualizado.setNome("Esther Santos");
        usuarioAtualizado.setEmail("novo@email.com");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuarioExistente));
        when(usuarioRepository.save(usuarioExistente)).thenReturn(usuarioExistente);

        Usuario resultado = usuarioService.atualizar(1L, usuarioAtualizado);

        assertEquals("Esther Santos", resultado.getNome());
        assertEquals("novo@email.com", resultado.getEmail());

        verify(usuarioRepository, times(1)).findById(1L);
        verify(usuarioRepository, times(1)).save(usuarioExistente);
    }

    @Test
    void deveDeletarUsuarioComSucesso() {
        usuarioService.deletar(1L);

        verify(usuarioRepository, times(1)).deleteById(1L);
    }
}