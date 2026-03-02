package com.br.crossfitdrive.domain.itemmovimento;


import com.br.crossfitdrive.domain.movimento.Movimento;
import com.br.crossfitdrive.domain.treino.Treino;

public class ItemMovimentoMapper {

    public static ItemMovimentoDto toDto(ItemMovimento entity) {
        if (entity == null) {
            return null;
        }

        ItemMovimentoDto dto = new ItemMovimentoDto();
        dto.setId(entity.getId());
        dto.setTreinoId(
                entity.getTreino() != null ? entity.getTreino().getId() : null
        );
        dto.setMovimentoId(
                entity.getMovimento() != null ? entity.getMovimento().getId() : null
        );
        dto.setCarga(entity.getCarga());
        dto.setRepeticao(entity.getRepeticao());
        dto.setObservacao(entity.getObservacao());
        return dto;
    }

    public static ItemMovimento toEntity(ItemMovimentoDto dto) {
        if (dto == null) {
            return null;
        }

        ItemMovimento entity = new ItemMovimento();
        entity.setId(dto.getId());
        if (dto.getTreinoId() != null) {
            Treino treino = new Treino();
            treino.setId(dto.getTreinoId());
            entity.setTreino(treino);
        }
        if (dto.getMovimentoId() != null) {
            Movimento movimento = new Movimento();
            movimento.setId(dto.getMovimentoId());
            entity.setMovimento(movimento);
        }
        entity.setCarga(dto.getCarga());
        entity.setRepeticao(dto.getRepeticao());
        entity.setObservacao(dto.getObservacao());
        return entity;
    }

}