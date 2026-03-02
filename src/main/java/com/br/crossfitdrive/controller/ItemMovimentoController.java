package com.br.crossfitdrive.controller;

import com.br.crossfitdrive.domain.itemmovimento.ItemMovimento;
import com.br.crossfitdrive.domain.itemmovimento.ItemMovimentoComponent;
import com.br.crossfitdrive.domain.itemmovimento.ItemMovimentoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-movimentos")
public class ItemMovimentoController {

    private final ItemMovimentoComponent component;

    public ItemMovimentoController(ItemMovimentoComponent component) {
        this.component = component;
    }

    @PostMapping
    public ResponseEntity<ItemMovimentoDto> salvar(@RequestBody ItemMovimentoDto item) {
        return ResponseEntity.ok(component.salvar(item));
    }

    @GetMapping("/treino/{treinoId}")
    public ResponseEntity<List<ItemMovimentoDto>> listar(@PathVariable Long treinoId) {
        return ResponseEntity.ok(component.listarPorTreino(treinoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemMovimentoDto> atualizar(
            @PathVariable Long id,
            @RequestBody ItemMovimentoDto item) {

        return ResponseEntity.ok(component.atualizar(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        component.deletar(id);
        return ResponseEntity.noContent().build();
    }

}