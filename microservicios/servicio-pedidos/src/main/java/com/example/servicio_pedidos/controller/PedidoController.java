package com.example.servicio_pedidos.controller;

import com.example.servicio_pedidos.model.Pedido;
import com.example.servicio_pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repo;

    @GetMapping
    public List<Pedido> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        pedido.setEstado("ACTIVO");
        return repo.save(pedido);
    }

    @GetMapping("/{id}")
    public Pedido obtener(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    /**
     * Cancela todos los pedidos ACTIVOS que referencian un producto eliminado.
     * Se llama desde el frontend antes de borrar el producto.
     */
    @PutMapping("/cancelar-por-producto/{productoId}")
    public void cancelarPorProducto(@PathVariable Long productoId) {
        List<Pedido> pedidos = repo.findByProductoId(productoId);
        pedidos.forEach(p -> {
            if ("ACTIVO".equals(p.getEstado())) {
                p.setEstado("CANCELADO");
                repo.save(p);
            }
        });
    }
}
