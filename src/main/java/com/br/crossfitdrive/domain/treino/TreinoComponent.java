package com.br.crossfitdrive.domain.treino;

import com.br.crossfitdrive.config.S3Service;
import com.br.crossfitdrive.domain.itemmovimento.ItemMovimento;
import com.br.crossfitdrive.domain.itemmovimento.ItemMovimentoMapper;
import com.br.crossfitdrive.domain.itemmovimento.ItemMovimentoService;
import com.br.crossfitdrive.domain.movimento.Movimento;
import com.br.crossfitdrive.domain.movimento.MovimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TreinoComponent {

    private final TreinoService service;
    private final ItemMovimentoService itemService;
    private final MovimentoService movimentoService;
    private final S3Service s3Service;

    public TreinoComponent(
            TreinoService service,
            ItemMovimentoService itemService,
            MovimentoService movimentoService, S3Service s3Service) {

        this.service = service;
        this.itemService = itemService;
        this.movimentoService = movimentoService;
        this.s3Service = s3Service;
    }

    public TreinoDto salvar(TreinoDto dto) {
        Treino entity = TreinoMapper.toEntity(dto);
        Treino treinoSalvo = service.salvar(entity);
        if (dto.getMovimentos() != null) {
            dto.getMovimentos().forEach(m -> {
                ItemMovimento item = new ItemMovimento();
                item.setTreino(treinoSalvo);
                Movimento movimento = new Movimento();
                movimento.setId(m.getMovimentoId());
                item.setMovimento(movimento);
                item.setRepeticao(m.getRepeticao());
                item.setCarga(m.getCarga());
                item.setUnidadeMedida(m.getUnidadeMedida());
                itemService.salvar(item);
            });
        }
        List<ItemMovimento> itens = itemService.buscarPorTreino(treinoSalvo.getId());
        TreinoDto response = TreinoMapper.toDto(treinoSalvo);
        response.setMovimentos(
                itens.stream()
                        .map(ItemMovimentoMapper::toDto)
                        .toList()
        );
        return response;
    }

    public List<TreinoDto> listar() {
        return service.listarTodos()
                .stream()
                .map(TreinoMapper::toDto)
                .collect(Collectors.toList());
    }

    public TreinoDto buscar(Long id) {
        Treino treino = service.buscarPorId(id);
        return TreinoMapper.toDto(treino);
    }

    public TreinoDto atualizar(Long id, TreinoDto dto) {
        Treino entity = TreinoMapper.toEntity(dto);
        Treino atualizado = service.atualizar(id, entity);
        return TreinoMapper.toDto(atualizado);
    }

    public void deletar(Long id) {
        TreinoDto treino = buscar(id);
        String url = treino.getMidiaUrl();
        if (url != null && !url.isEmpty()) {
            String key = url.substring(url.lastIndexOf("/") + 1);
            s3Service.deleteImage(key);
        }
        service.deletar(id);
    }

}