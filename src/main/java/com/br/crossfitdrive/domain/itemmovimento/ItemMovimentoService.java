package com.br.crossfitdrive.domain.itemmovimento;

import java.util.List;

public interface ItemMovimentoService {

    ItemMovimento salvar(ItemMovimento itemMovimento);

    List<ItemMovimento> listarPorTreino(Long treinoId);

    ItemMovimento atualizar(Long id, ItemMovimento itemMovimento);

    void deletar(Long id);

}
