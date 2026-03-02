package com.br.crossfitdrive.domain.itemmovimento;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMovimentoComponent {

    private final ItemMovimentoService service;

    public ItemMovimentoComponent(ItemMovimentoService service) {
        this.service = service;
    }

    public ItemMovimentoDto salvar(ItemMovimentoDto dto) {
        ItemMovimento entity = ItemMovimentoMapper.toEntity(dto);
        ItemMovimento salvo = service.salvar(entity);
        return ItemMovimentoMapper.toDto(salvo);
    }

    public List<ItemMovimentoDto> listarPorTreino(Long treinoId) {
        return service.listarPorTreino(treinoId)
                .stream()
                .map(ItemMovimentoMapper::toDto)
                .collect(Collectors.toList());
    }

    public ItemMovimentoDto atualizar(Long id, ItemMovimentoDto dto) {
        ItemMovimento entity = ItemMovimentoMapper.toEntity(dto);
        ItemMovimento atualizado = service.atualizar(id, entity);
        return ItemMovimentoMapper.toDto(atualizado);
    }

    public void deletar(Long id) {
        service.deletar(id);
    }

}