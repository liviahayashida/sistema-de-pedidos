
package com.example.sistema_de_pedidos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaDePedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaDePedidosApplication.class, args);
    }

    @Bean
    CommandLineRunner executarTeste(PedidoRepository pedidoRepository) {
        return args -> {
            Pedido pedido = new Pedido();
            pedido.setCliente("Maria");
            pedido.setStatus(StatusPedido.PENDENTE);

            ItemPedido item1 = new ItemPedido();
            item1.setProduto("Teclado");
            item1.setPreco(100.0);

            ItemPedido item2 = new ItemPedido();
            item2.setProduto("Mouse");
            item2.setPreco(50.0);

            pedido.addItem(item1);
            pedido.addItem(item2);

            Pedido pedidoSalvo = pedidoRepository.save(pedido);

            pedidoRepository.delete(pedidoSalvo);
        };
    }
}