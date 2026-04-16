package com.br.pedido.controller;


import com.br.pedido.config.RabbitMQConstantes;
import com.br.pedido.dto.PedidoDto;
import com.br.pedido.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pediddo")
public class PedidoController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    public ResponseEntity<String> alterarPreco(@RequestBody PedidoDto pedidoDto) {
        this.rabbitMQService.enviarMensagem(RabbitMQConstantes.FILA_PEDIDO, pedidoDto);
        return ResponseEntity.ok("Pedido enviado com sucesso");
    }

}
