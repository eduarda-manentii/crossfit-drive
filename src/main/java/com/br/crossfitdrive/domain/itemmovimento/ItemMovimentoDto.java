package com.br.crossfitdrive.domain.itemmovimento;

import lombok.Data;

@Data
public class ItemMovimentoDto {

    private Long id;
    private Long treinoId;
    private Long movimentoId;

    private Double carga;
    private Integer repeticao;
    private String observacao;
    private String unidadeMedida;

}
