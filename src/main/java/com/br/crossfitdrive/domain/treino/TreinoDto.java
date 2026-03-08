package com.br.crossfitdrive.domain.treino;

import com.br.crossfitdrive.domain.itemmovimento.ItemMovimentoDto;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

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
    private List<ItemMovimentoDto> movimentos;
    private String midiaUrl;

}