package com.br.crossfitdrive.controller;

import com.br.crossfitdrive.domain.movimento.MovimentoComponent;
import com.br.crossfitdrive.domain.movimento.MovimentoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentos")
public class MovimentoController {

    private final MovimentoComponent component;

    public MovimentoController(MovimentoComponent component) {
        this.component = component;
    }

    @PostMapping
    public ResponseEntity<MovimentoDto> criar(@RequestBody MovimentoDto dto) {
        return ResponseEntity.ok(component.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<MovimentoDto>> listar() {
        return ResponseEntity.ok(component.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimentoDto> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(component.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimentoDto> atualizar(
            @PathVariable Long id,
            @RequestBody MovimentoDto dto) {

        return ResponseEntity.ok(component.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        component.deletar(id);
        return ResponseEntity.noContent().build();
    }

}