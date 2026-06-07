package com.br.esther.controle_tarefas.service;

import com.br.esther.controle_tarefas.exception.ResourceNotFoundException;
import com.br.esther.controle_tarefas.model.Tarefa;
import com.br.esther.controle_tarefas.model.Usuario;
import com.br.esther.controle_tarefas.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Testes unitários da camada de serviço de tarefas.
@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @Test
    void deveSalvarTarefaComSucesso() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Estudar Spring Boot");
        tarefa.setDescricao("Revisar service e repository");
        tarefa.setStatus("PENDENTE");
        tarefa.setDataCriacao(LocalDate.now());
        tarefa.setUsuario(usuario);

        when(tarefaRepository.save(tarefa)).thenReturn(tarefa);

        Tarefa resultado = tarefaService.salvar(tarefa);

        assertNotNull(resultado);
        assertEquals("Estudar Spring Boot", resultado.getTitulo());
        assertEquals("PENDENTE", resultado.getStatus());

        verify(tarefaRepository, times(1)).save(tarefa);
    }

    @Test
    void deveListarTodasTarefas() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Fazer testes");
        tarefa.setStatus("PENDENTE");

        when(tarefaRepository.findAll()).thenReturn(List.of(tarefa));

        List<Tarefa> resultado = tarefaService.listarTodas();

        assertEquals(1, resultado.size());
        assertEquals("Fazer testes", resultado.get(0).getTitulo());

        verify(tarefaRepository, times(1)).findAll();
    }

    @Test
    void deveBuscarTarefaPorIdComSucesso() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Projeto Final");
        tarefa.setStatus("EM_ANDAMENTO");

        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        Tarefa resultado = tarefaService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Projeto Final", resultado.getTitulo());

        verify(tarefaRepository, times(1)).findById(1L);
    }

    @Test
    void deveLancarExcecaoQuandoTarefaNaoForEncontrada() {
        when(tarefaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            tarefaService.buscarPorId(99L);
        });

        verify(tarefaRepository, times(1)).findById(99L);
    }

    @Test
    void deveAtualizarTarefaComSucesso() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        Tarefa tarefaExistente = new Tarefa();
        tarefaExistente.setId(1L);
        tarefaExistente.setTitulo("Título antigo");
        tarefaExistente.setDescricao("Descrição antiga");
        tarefaExistente.setStatus("PENDENTE");
        tarefaExistente.setUsuario(usuario);

        Tarefa tarefaAtualizada = new Tarefa();
        tarefaAtualizada.setTitulo("Título novo");
        tarefaAtualizada.setDescricao("Descrição nova");
        tarefaAtualizada.setStatus("CONCLUIDA");
        tarefaAtualizada.setUsuario(usuario);

        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefaExistente));
        when(tarefaRepository.save(tarefaExistente)).thenReturn(tarefaExistente);

        Tarefa resultado = tarefaService.atualizar(1L, tarefaAtualizada);

        assertEquals("Título novo", resultado.getTitulo());
        assertEquals("Descrição nova", resultado.getDescricao());
        assertEquals("CONCLUIDA", resultado.getStatus());

        verify(tarefaRepository, times(1)).findById(1L);
        verify(tarefaRepository, times(1)).save(tarefaExistente);
    }

    @Test
    void deveDeletarTarefaComSucesso() {
        tarefaService.deletar(1L);

        verify(tarefaRepository, times(1)).deleteById(1L);
    }

    @Test
    void deveBuscarTarefasPorStatus() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Finalizar projeto");
        tarefa.setStatus("PENDENTE");

        when(tarefaRepository.findByStatus("PENDENTE")).thenReturn(List.of(tarefa));

        List<Tarefa> resultado = tarefaService.buscarPorStatus("PENDENTE");

        assertEquals(1, resultado.size());
        assertEquals("PENDENTE", resultado.get(0).getStatus());
        assertEquals("Finalizar projeto", resultado.get(0).getTitulo());

        verify(tarefaRepository, times(1)).findByStatus("PENDENTE");
    }
}