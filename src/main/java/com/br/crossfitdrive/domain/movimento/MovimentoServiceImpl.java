package com.br.crossfitdrive.domain.movimento;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentoServiceImpl implements MovimentoService {

    private final MovimentoRepository repository;

    public MovimentoServiceImpl(MovimentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Movimento salvar(Movimento movimento) {
        return repository.save(movimento);
    }

    @Override
    public List<Movimento> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Movimento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimento não encontrado"));
    }

    @Override
    public Movimento atualizar(Long id, Movimento movimentoAtualizado) {
        Movimento movimento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimento não encontrado"));

        movimento.setNome(movimentoAtualizado.getNome());
        movimento.setUnidadeMedida(movimentoAtualizado.getUnidadeMedida());
        return repository.save(movimento);
    }

    @Override
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Movimento não encontrado");
        }
        repository.deleteById(id);
    }

}
