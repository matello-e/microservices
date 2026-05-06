/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.servicio_usuarios.repository;
import com.example.servicio_usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USUARIO
 */

public interface UsuarioRepository 
        extends JpaRepository<Usuario, Long> {
}
