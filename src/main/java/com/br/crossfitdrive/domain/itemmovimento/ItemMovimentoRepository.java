package com.br.crossfitdrive.domain.itemmovimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMovimentoRepository extends JpaRepository<ItemMovimento, Long> {
    List<ItemMovimento> findByTreino_Id(Long treinoId);
}
