package com.br.crossfitdrive.domain.movimento;

public class MovimentoMapper {

    public static MovimentoDto toDto(Movimento entity) {
        if (entity == null) {
            return null;
        }
        MovimentoDto dto = new MovimentoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setTipo(entity.getTipo());
        return dto;
    }

    public static Movimento toEntity(MovimentoDto dto) {
        if (dto == null) {
            return null;
        }
        Movimento entity = new Movimento();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setTipo(dto.getTipo());
        return entity;
    }

}