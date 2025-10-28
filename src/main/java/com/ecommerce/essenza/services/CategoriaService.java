package com.ecommerce.essenza.services;

import com.ecommerce.essenza.models.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> getAllCategorias();
    Optional<Categoria> getCategoriaById(Long id);
    Categoria saveCategoria(Categoria categoria);
    Categoria updateCategoria(Long id, Categoria categoria);
    Categoria deleteCategoria(Long id);


}
