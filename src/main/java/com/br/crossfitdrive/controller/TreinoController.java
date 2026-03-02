package com.br.crossfitdrive.controller;

import com.br.crossfitdrive.domain.treino.TreinoComponent;
import com.br.crossfitdrive.domain.treino.TreinoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    private final TreinoComponent component;

    public TreinoController(TreinoComponent component) {
        this.component = component;
    }

    @PostMapping
    public ResponseEntity<TreinoDto> criar(@RequestBody TreinoDto dto) {
        return ResponseEntity.ok(component.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<TreinoDto>> listar() {
        return ResponseEntity.ok(component.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoDto> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(component.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoDto> atualizar(
            @PathVariable Long id,
            @RequestBody TreinoDto dto) {

        return ResponseEntity.ok(component.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        component.deletar(id);
        return ResponseEntity.noContent().build();
    }

}