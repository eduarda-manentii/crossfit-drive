package com.br.crossfitdrive.domain.treino;

import com.br.crossfitdrive.domain.itemmovimento.ItemMovimento;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "treino")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "observacao")
    private String observacao;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL)
    private List<ItemMovimento> movimentos;

    @Column(name = "midia_url")
    private String midiaUrl;

}
