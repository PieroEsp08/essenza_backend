package com.ecommerce.essenza.services;

import com.ecommerce.essenza.models.Pedido;
import com.ecommerce.essenza.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> getPedidoById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido updatePedido(Long id, Pedido pedidoDetails) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setUsuario(pedidoDetails.getUsuario());
            pedido.setFecha(pedidoDetails.getFecha());
            pedido.setTotal(pedidoDetails.getTotal());
            pedido.setEstado(pedidoDetails.getEstado());
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    @Override
    public Pedido deletePedido(Long id) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setEstado(0); // Eliminación lógica
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
}
