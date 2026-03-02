package com.br.crossfitdrive.domain.itemmovimento;

import com.br.crossfitdrive.domain.movimento.MovimentoRepository;
import com.br.crossfitdrive.domain.treino.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMovimentoServiceImpl implements ItemMovimentoService {

    private final ItemMovimentoRepository repository;
    private final TreinoRepository treinoRepository;
    private final MovimentoRepository movimentoRepository;

    public ItemMovimentoServiceImpl(
            ItemMovimentoRepository repository,
            TreinoRepository treinoRepository,
            MovimentoRepository movimentoRepository
    ) {
        this.repository = repository;
        this.treinoRepository = treinoRepository;
        this.movimentoRepository = movimentoRepository;
    }

    @Override
    public ItemMovimento salvar(ItemMovimento item) {
        var treino = treinoRepository.findById(item.getTreino().getId())
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        var movimento = movimentoRepository.findById(item.getMovimento().getId())
                .orElseThrow(() -> new RuntimeException("Movimento não encontrado"));

        item.setTreino(treino);
        item.setMovimento(movimento);
        return repository.save(item);
    }

    @Override
    public List<ItemMovimento> listarPorTreino(Long treinoId) {
        return repository.findByTreino_Id(treinoId);
    }

    @Override
    public ItemMovimento atualizar(Long id, ItemMovimento itemAtualizado) {
        ItemMovimento item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemMovimento não encontrado"));
        item.setCarga(itemAtualizado.getCarga());
        item.setRepeticao(itemAtualizado.getRepeticao());
        item.setObservacao(itemAtualizado.getObservacao());
        return repository.save(item);
    }

    @Override
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ItemMovimento não encontrado");
        }
        repository.deleteById(id);
    }

}