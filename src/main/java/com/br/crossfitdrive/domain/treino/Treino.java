package com.br.crossfitdrive.domain.treino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "treino")
public class Treino {

    @Id
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "data", nullable = false)
    private OffsetDateTime data;

    @Column(name = "repeticao_estimada", nullable = false)
    private Integer repeticaoEstimada;

    @Column(name = "repeticao_feita", nullable = false)
    private Integer repeticaoFeita;

    @Column(name = "tempo_estimado", nullable = false)
    private Integer tempoEstimado;

    @Column(name = "tempo_feito", nullable = false)
    private Integer tempoFeito;

    @Column(name = "observacao", nullable = false)
    private String observacao;

}
