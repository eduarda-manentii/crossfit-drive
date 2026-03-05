package com.br.crossfitdrive.domain.treino;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoServiceImpl implements TreinoService {

    private final TreinoRepository repository;

    public TreinoServiceImpl(TreinoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Treino salvar(Treino treino) {
        return repository.save(treino);
    }

    @Override
    public List<Treino> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Treino buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado com id: " + id));
    }

    @Override
    public Treino atualizar(Long id, Treino treino) {
        Treino existente = buscarPorId(id);
        existente.setData(treino.getData());
        existente.setNome(treino.getNome());
        existente.setTipo(treino.getTipo());
        existente.setRepeticaoFeita(treino.getRepeticaoFeita());
        existente.setRepeticaoEstimada(treino.getRepeticaoEstimada());
        existente.setTempoEstimado(treino.getTempoEstimado());
        existente.setTempoFeito(treino.getTempoFeito());
        existente.setObservacao(treino.getObservacao());
        return repository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        Treino existente = buscarPorId(id);
        repository.delete(existente);
    }

}