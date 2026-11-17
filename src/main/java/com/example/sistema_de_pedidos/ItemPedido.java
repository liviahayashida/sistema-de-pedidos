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

   @Column
private Double preco;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public void setProduto(String produto) {
    this.produto = produto;
}

public void setPreco(Double preco) {
    this.preco = preco;
}

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}