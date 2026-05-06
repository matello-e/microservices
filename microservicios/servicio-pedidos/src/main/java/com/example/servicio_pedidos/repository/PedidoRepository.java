package com.example.servicio_pedidos.repository;

import com.example.servicio_pedidos.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByProductoId(Long productoId);
}