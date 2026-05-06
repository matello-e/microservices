/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.servicio_productos.repository;

import com.example.servicio_productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USUARIO
 */

public interface ProductoRepository 
        extends JpaRepository<Producto, Long> {

    @Override
    public void deleteById(Long id);
}
