package com.br.crossfitdrive.domain.movimento;


import java.util.List;

public interface MovimentoService {

    Movimento salvar(Movimento movimento);

    List<Movimento> listarTodos();

    Movimento buscarPorId(Long id);

    Movimento atualizar(Long id, Movimento movimento);

    void deletar(Long id);

}
