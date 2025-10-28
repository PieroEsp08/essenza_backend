package com.ecommerce.essenza.services;

import com.ecommerce.essenza.models.Perfume;

import java.util.List;
import java.util.Optional;

public interface PerfumeService {

    List<Perfume> getAllPerfumes();
    Optional<Perfume> getPerfumeById(Long id);
    Perfume savePerfume(Perfume perfume);
    Perfume updatePerfume(Long id, Perfume perfume);
    Perfume deletePerfume(Long id);

    List<Perfume>  buscarPorNombre(String nombre);

    // Métodos personalizados para filtros
    List<Perfume> findByCategoriaId(Long categoriaId);
    List<Perfume> findByGeneroId(Long generoId);
    List<Perfume> findByMarcaId(Long marcaId);
    List<Perfume> findByCategoriaIdAndGeneroIdAndMarcaId(Long categoriaId, Long generoId, Long marcaId);

}
