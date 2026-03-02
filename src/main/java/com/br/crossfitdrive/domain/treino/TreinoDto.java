package com.br.crossfitdrive.domain.treino;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class TreinoDto {

    private Long id;
    private OffsetDateTime data;
    private Integer repeticao;
    private Integer tempoEstimado;
    private Integer tempoFeito;
    private String observacao;
}