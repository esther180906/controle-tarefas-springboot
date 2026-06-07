package com.br.esther.controle_tarefas.controller;

import com.br.esther.controle_tarefas.dto.UsuarioDTO;
import com.br.esther.controle_tarefas.model.Usuario;
import com.br.esther.controle_tarefas.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Testes do controller de usuários
@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCadastrarUsuarioComSucesso() throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Esther");
        usuario.setEmail("esther@email.com");

        when(usuarioService.salvar(any(Usuario.class))).thenReturn(usuario);

        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome("Esther");
        dto.setEmail("esther@email.com");

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Esther"));

        verify(usuarioService, times(1)).salvar(any(Usuario.class));
    }

    @Test
    void deveListarUsuarios() throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Esther");
        usuario.setEmail("esther@email.com");

        when(usuarioService.listarTodos())
                .thenReturn(List.of(usuario));

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nome").value("Esther"));

        verify(usuarioService, times(1)).listarTodos();
    }

    @Test
    void deveBuscarUsuarioPorId() throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Esther");
        usuario.setEmail("esther@email.com");

        when(usuarioService.buscarPorId(1L))
                .thenReturn(usuario);

        mockMvc.perform(get("/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Esther"));

        verify(usuarioService, times(1)).buscarPorId(1L);
    }

    @Test
    void deveDeletarUsuario() throws Exception {

        doNothing().when(usuarioService).deletar(1L);

        mockMvc.perform(delete("/usuarios/1"))
                .andExpect(status().isOk());

        verify(usuarioService, times(1)).deletar(1L);
    }

    @Test
    void deveAtualizarUsuarioComSucesso() throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Esther Santos");
        usuario.setEmail("esther.santos@email.com");

        when(usuarioService.atualizar(eq(1L), any(Usuario.class)))
                .thenReturn(usuario);

        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome("Esther Santos");
        dto.setEmail("esther.santos@email.com");

        mockMvc.perform(put("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Esther Santos"));

        verify(usuarioService, times(1))
                .atualizar(eq(1L), any(Usuario.class));
    }
}