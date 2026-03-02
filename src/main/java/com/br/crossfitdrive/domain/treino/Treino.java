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

    @Column(name = "data", nullable = false)
    private OffsetDateTime data;

    @Column(name = "repeticao", nullable = false)
    private Integer repeticao;

    @Column(name = "tempoEstimado", nullable = false)
    private Integer tempoEstimado;

    @Column(name = "tempoFeito", nullable = false)
    private Integer tempoFeito;

    @Column(name = "observacao", nullable = false)
    private String observacao;

}
