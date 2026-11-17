package com.example.sistema_de_pedidos;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String cliente;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @OneToMany(
        mappedBy = "pedido",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<ItemPedido> itens = new ArrayList<>();

    public void addItem(ItemPedido item) {
        itens.add(item);
        item.setPedido(this);
    }

    public void removeItem(ItemPedido item) {
        itens.remove(item);
        item.setPedido(null);
    }
}