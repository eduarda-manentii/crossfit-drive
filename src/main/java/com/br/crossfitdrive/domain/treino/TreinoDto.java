package com.br.crossfitdrive.domain.treino;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class TreinoDto {

    private Long id;
    private String nome;
    private String tipo;
    private OffsetDateTime data;
    private Integer repeticaoEstimada;
    private Integer repeticaoFeita;
    private Integer tempoEstimado;
    private Integer tempoFeito;
    private String observacao;
}