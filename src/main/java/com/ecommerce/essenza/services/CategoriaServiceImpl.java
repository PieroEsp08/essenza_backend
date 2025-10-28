package com.ecommerce.essenza.services;

import com.ecommerce.essenza.models.Categoria;
import com.ecommerce.essenza.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Long id, Categoria categoriaDetails) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNombre(categoriaDetails.getNombre());
            categoria.setImagenUrl(categoriaDetails.getImagenUrl());
            categoria.setEstado(categoriaDetails.getEstado());
            return categoriaRepository.save(categoria);
        }).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    @Override
    public Categoria deleteCategoria(Long id) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setEstado(0); // Eliminación lógica
            return categoriaRepository.save(categoria);
        }).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }
}
