package com.br.crossfitdrive.domain.treino;

import java.util.List;

public interface TreinoService {

    Treino salvar(Treino treino);

    List<Treino> listarTodos();

    Treino buscarPorId(Long id);

    Treino atualizar(Long id, Treino treino);

    void deletar(Long id);

}