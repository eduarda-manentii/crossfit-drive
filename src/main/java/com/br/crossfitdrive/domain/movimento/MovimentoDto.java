package com.br.crossfitdrive.domain.movimento;

import lombok.Data;

@Data
public class MovimentoDto {

    private Long id;
    private String nome;
    private String descricao;
    private String tipo;

}