package com.example.servicio_pedidos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clienteNombre;

    private Long productoId;

    private Integer cantidad;

    // ACTIVO | CANCELADO
    private String estado = "ACTIVO";

    private LocalDateTime fecha;

    @PrePersist
    public void prePersist() {
        this.fecha  = LocalDateTime.now();
        if (this.estado == null) this.estado = "ACTIVO";
    }
}
