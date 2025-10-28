package com.ecommerce.essenza.repositories;

import com.ecommerce.essenza.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
