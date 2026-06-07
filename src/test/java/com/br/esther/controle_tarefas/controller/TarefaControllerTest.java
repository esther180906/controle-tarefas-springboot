package com.br.esther.controle_tarefas.controller;

import com.br.esther.controle_tarefas.dto.TarefaDTO;
import com.br.esther.controle_tarefas.model.Tarefa;
import com.br.esther.controle_tarefas.model.Usuario;
import com.br.esther.controle_tarefas.service.TarefaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Testes do controller de tarefas.
@WebMvcTest(TarefaController.class)
public class TarefaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TarefaService tarefaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCadastrarTarefaComSucesso() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Estudar Spring Boot");
        tarefa.setDescricao("Fazer testes do controller");
        tarefa.setStatus("PENDENTE");
        tarefa.setUsuario(usuario);

        when(tarefaService.salvar(any(Tarefa.class))).thenReturn(tarefa);

        TarefaDTO dto = new TarefaDTO();
        dto.setTitulo("Estudar Spring Boot");
        dto.setDescricao("Fazer testes do controller");
        dto.setStatus("PENDENTE");
        dto.setUsuarioId(1L);

        mockMvc.perform(post("/tarefas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.titulo").value("Estudar Spring Boot"))
                .andExpect(jsonPath("$.status").value("PENDENTE"));

        verify(tarefaService, times(1)).salvar(any(Tarefa.class));
    }

    @Test
    void deveListarTodasTarefas() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Finalizar projeto");
        tarefa.setStatus("PENDENTE");

        when(tarefaService.listarTodas()).thenReturn(List.of(tarefa));

        mockMvc.perform(get("/tarefas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].titulo").value("Finalizar projeto"))
                .andExpect(jsonPath("$[0].status").value("PENDENTE"));

        verify(tarefaService, times(1)).listarTodas();
    }

    @Test
    void deveBuscarTarefaPorId() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Projeto Final");
        tarefa.setStatus("EM_ANDAMENTO");

        when(tarefaService.buscarPorId(1L)).thenReturn(tarefa);

        mockMvc.perform(get("/tarefas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.titulo").value("Projeto Final"))
                .andExpect(jsonPath("$.status").value("EM_ANDAMENTO"));

        verify(tarefaService, times(1)).buscarPorId(1L);
    }

    @Test
    void deveDeletarTarefa() throws Exception {
        doNothing().when(tarefaService).deletar(1L);

        mockMvc.perform(delete("/tarefas/1"))
                .andExpect(status().isOk());

        verify(tarefaService, times(1)).deletar(1L);
    }

    @Test
    void deveAtualizarTarefaComSucesso() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Título atualizado");
        tarefa.setDescricao("Descrição atualizada");
        tarefa.setStatus("CONCLUIDA");
        tarefa.setUsuario(usuario);

        when(tarefaService.atualizar(eq(1L), any(Tarefa.class))).thenReturn(tarefa);

        TarefaDTO dto = new TarefaDTO();
        dto.setTitulo("Título atualizado");
        dto.setDescricao("Descrição atualizada");
        dto.setStatus("CONCLUIDA");
        dto.setUsuarioId(1L);

        mockMvc.perform(put("/tarefas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.titulo").value("Título atualizado"))
                .andExpect(jsonPath("$.status").value("CONCLUIDA"));

        verify(tarefaService, times(1)).atualizar(eq(1L), any(Tarefa.class));
    }

    @Test
    void deveBuscarTarefasPorStatus() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Finalizar trabalho");
        tarefa.setStatus("PENDENTE");

        when(tarefaService.buscarPorStatus("PENDENTE")).thenReturn(List.of(tarefa));

        mockMvc.perform(get("/tarefas/status/PENDENTE"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].titulo").value("Finalizar trabalho"))
                .andExpect(jsonPath("$[0].status").value("PENDENTE"));

        verify(tarefaService, times(1)).buscarPorStatus("PENDENTE");
    }
}