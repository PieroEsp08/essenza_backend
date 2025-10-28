package com.ecommerce.essenza.services;

import com.ecommerce.essenza.models.Genero;
import com.ecommerce.essenza.models.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {

    List<Marca> getAllMarcas();
    Optional<Marca> getMarcaById(Long id);
    Marca saveMarca(Marca marca);
    Marca updateMarca(Long id, Marca marca);
    Marca deleteMarca(Long id);
}
