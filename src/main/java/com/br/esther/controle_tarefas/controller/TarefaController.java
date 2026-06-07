package com.br.esther.controle_tarefas.controller;

import com.br.esther.controle_tarefas.dto.TarefaDTO;
import com.br.esther.controle_tarefas.model.Tarefa;
import com.br.esther.controle_tarefas.model.Usuario;
import com.br.esther.controle_tarefas.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tarefas", description = "Endpoints para gerenciamento de tarefas")
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Operation(summary = "Cadastrar tarefa", description = "Cria uma nova tarefa vinculada a um usuário.")
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

    @Operation(summary = "Listar tarefas", description = "Retorna todas as tarefas cadastradas.")
    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaService.listarTodas();
    }

    @Operation(summary = "Buscar tarefa por ID", description = "Busca uma tarefa específica pelo ID.")
    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @Operation(summary = "Deletar tarefa", description = "Remove uma tarefa pelo ID.")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
    }

    @Operation(summary = "Atualizar tarefa", description = "Atualiza os dados de uma tarefa existente.")
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

    @Operation(summary = "Buscar tarefas por status", description = "Filtra tarefas pelo status informado.")
    @GetMapping("/status/{status}")
    public List<Tarefa> buscarPorStatus(@PathVariable String status) {
        return tarefaService.buscarPorStatus(status);
    }
}