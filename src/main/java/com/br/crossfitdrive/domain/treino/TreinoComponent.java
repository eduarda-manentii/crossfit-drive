package com.br.crossfitdrive.domain.treino;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TreinoComponent {

    private final TreinoService service;

    public TreinoComponent(TreinoService service) {
        this.service = service;
    }

    public TreinoDto salvar(TreinoDto dto) {
        Treino entity = TreinoMapper.toEntity(dto);
        Treino salvo = service.salvar(entity);
        return TreinoMapper.toDto(salvo);
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
        service.deletar(id);
    }

}