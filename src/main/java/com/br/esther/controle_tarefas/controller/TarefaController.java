package com.br.esther.controle_tarefas.controller;

import com.br.esther.controle_tarefas.model.Tarefa;
import com.br.esther.controle_tarefas.service.TarefaService;
import org.springframework.web.bind.annotation.*;
import com.br.esther.controle_tarefas.dto.TarefaDTO;
import com.br.esther.controle_tarefas.model.Usuario;
import jakarta.validation.Valid;

import java.util.List;

// Controller responsável por receber as requisições relacionadas às tarefas
// e encaminhá-las para a camada de serviço.
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public Tarefa salvar(@RequestBody @Valid TarefaDTO tarefaDTO) {

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setStatus(tarefaDTO.getStatus());

        Usuario usuario = new Usuario();
        usuario.setId(tarefaDTO.getUsuarioId());

        tarefa.setUsuario(usuario);

        return tarefaService.salvar(tarefa);
    }

    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id,
                            @RequestBody @Valid TarefaDTO tarefaDTO) {

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setStatus(tarefaDTO.getStatus());

        Usuario usuario = new Usuario();
        usuario.setId(tarefaDTO.getUsuarioId());

        tarefa.setUsuario(usuario);

        return tarefaService.atualizar(id, tarefa);
    }
}