package com.ecommerce.essenza.repositories;

import com.ecommerce.essenza.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
