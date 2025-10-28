package com.ecommerce.essenza.services;


import com.ecommerce.essenza.models.Genero;
import java.util.List;
import java.util.Optional;

public interface GeneroService {

    List<Genero> getAllGeneros();
    Optional<Genero> getGeneroById(Long id);
    Genero saveGenero(Genero genero);
    Genero updateGenero(Long id, Genero genero);
    Genero deleteGenero(Long id);
}
