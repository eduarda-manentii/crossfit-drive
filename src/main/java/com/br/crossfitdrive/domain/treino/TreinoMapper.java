package com.br.crossfitdrive.domain.treino;

public class TreinoMapper {

    public static TreinoDto toDto(Treino entity) {
        if (entity == null) return null;
        TreinoDto dto = new TreinoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setTipo(entity.getTipo());
        dto.setData(entity.getData());
        dto.setRepeticaoEstimada(entity.getRepeticaoEstimada());
        dto.setRepeticaoFeita(entity.getRepeticaoFeita());
        dto.setTempoEstimado(entity.getTempoEstimado());
        dto.setTempoFeito(entity.getTempoFeito());
        dto.setObservacao(entity.getObservacao());
        return dto;
    }

    public static Treino toEntity(TreinoDto dto) {
        if (dto == null) return null;
        Treino entity = new Treino();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setTipo(dto.getTipo());
        entity.setData(dto.getData());
        entity.setRepeticaoEstimada(dto.getRepeticaoEstimada());
        entity.setRepeticaoFeita(dto.getRepeticaoFeita());
        entity.setTempoEstimado(dto.getTempoEstimado());
        entity.setTempoFeito(dto.getTempoFeito());
        entity.setObservacao(dto.getObservacao());
        return entity;
    }

}