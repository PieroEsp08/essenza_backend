package com.ecommerce.essenza.repositories;

import com.ecommerce.essenza.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
