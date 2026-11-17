package com.example.sistema_de_pedidos;

import jakarta.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String produto;

    @Column(precision = 10, scale = 2)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}