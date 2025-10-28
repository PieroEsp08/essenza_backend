package com.ecommerce.essenza.services;

import com.ecommerce.essenza.models.Categoria;
import com.ecommerce.essenza.models.Genero;
import com.ecommerce.essenza.repositories.CategoriaRepository;
import com.ecommerce.essenza.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {


    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }

    @Override
    public Optional<Genero> getGeneroById(Long id) {
        return generoRepository.findById(id);
    }

    @Override
    public Genero saveGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public Genero updateGenero(Long id, Genero generoDetails) {
        return generoRepository.findById(id).map(genero -> {
            genero.setNombre(generoDetails.getNombre());
            genero.setImagenUrl(generoDetails.getImagenUrl());
            genero.setEstado(generoDetails.getEstado());
            return generoRepository.save(genero);
        }).orElseThrow(() -> new RuntimeException("Genero no encontrado"));
    }

    @Override
    public Genero deleteGenero(Long id) {
        return generoRepository.findById(id).map(genero -> {
            genero.setEstado(0); // Eliminación lógica
            return generoRepository.save(genero);
        }).orElseThrow(() -> new RuntimeException("Genero no encontrada"));
    }
}
