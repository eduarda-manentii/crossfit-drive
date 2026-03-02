package com.br.crossfitdrive.domain.movimento;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovimentoComponent {

    private final MovimentoService service;

    public MovimentoComponent(MovimentoService service) {
        this.service = service;
    }

    public MovimentoDto criar(MovimentoDto dto) {
        Movimento entity = MovimentoMapper.toEntity(dto);
        Movimento salvo = service.salvar(entity);
        return MovimentoMapper.toDto(salvo);
    }

    public List<MovimentoDto> listar() {
        return service.listarTodos()
                .stream()
                .map(MovimentoMapper::toDto)
                .collect(Collectors.toList());
    }

    public MovimentoDto buscar(Long id) {
        Movimento movimento = service.buscarPorId(id);
        return MovimentoMapper.toDto(movimento);
    }

    public MovimentoDto atualizar(Long id, MovimentoDto dto) {

        Movimento entity = MovimentoMapper.toEntity(dto);
        Movimento atualizado = service.atualizar(id, entity);

        return MovimentoMapper.toDto(atualizado);
    }

    public void deletar(Long id) {
        service.deletar(id);
    }

}