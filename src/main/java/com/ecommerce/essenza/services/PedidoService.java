package com.ecommerce.essenza.services;

import com.ecommerce.essenza.models.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> getAllPedidos();
    Optional<Pedido> getPedidoById(Long id);
    Pedido savePedido(Pedido pedido);
    Pedido updatePedido(Long id, Pedido pedido);
    Pedido deletePedido(Long id);

}
