// Classe responsável por gerenciar as operações relacionadas às tarefas,
// como cadastro, consulta, busca por ID e exclusão.

package com.br.esther.controle_tarefas.service;

import com.br.esther.controle_tarefas.model.Tarefa;
import com.br.esther.controle_tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import com.br.esther.controle_tarefas.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }

    public Tarefa atualizar(Long id, Tarefa tarefa) {

        Tarefa tarefaExistente = buscarPorId(id);

        tarefaExistente.setTitulo(tarefa.getTitulo());
        tarefaExistente.setDescricao(tarefa.getDescricao());
        tarefaExistente.setStatus(tarefa.getStatus());
        tarefaExistente.setUsuario(tarefa.getUsuario());

        return tarefaRepository.save(tarefaExistente);
    }

    // Busca todas as tarefas com o status informado.
    public List<Tarefa> buscarPorStatus(String status) {
        return tarefaRepository.findByStatus(status);
    }
}