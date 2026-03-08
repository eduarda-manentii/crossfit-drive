package com.br.crossfitdrive.domain.itemmovimento;

import com.br.crossfitdrive.domain.movimento.Movimento;
import com.br.crossfitdrive.domain.treino.Treino;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "item_movimento")
public class ItemMovimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    private Treino treino;

    @ManyToOne
    @JoinColumn(name = "movimento_id")
    private Movimento movimento;

    @Column(name = "carga", nullable = false)
    private Double carga;

    @Column(name = "repeticao", nullable = false)
    private Integer repeticao;

    @Column(name = "unidade_medida", nullable = false)
    private String unidadeMedida;

}
