package com.ecommerce.essenza.repositories;

import com.ecommerce.essenza.models.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfumeRepository extends JpaRepository<Perfume,Long> {

    List<Perfume> findByNombreContainingIgnoreCase(String nombre);

    // Métodos personalizados para filtros
    List<Perfume> findByCategoriaId(Long categoriaId);
    List<Perfume> findByGeneroId(Long generoId);
    List<Perfume> findByMarcaId(Long marcaId);
    List<Perfume> findByCategoriaIdAndGeneroIdAndMarcaId(Long categoriaId, Long generoId, Long marcaId);

}
