package com.ecommerce.essenza.services;

import com.ecommerce.essenza.models.Marca;
import com.ecommerce.essenza.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> getMarcaById(Long id) {
        return marcaRepository.findById(id);
    }

    @Override
    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca updateMarca(Long id, Marca marcaDetails) {
        return marcaRepository.findById(id).map(marca -> {
            marca.setNombre(marcaDetails.getNombre());
            marca.setEstado(marcaDetails.getEstado());
            return marcaRepository.save(marca);
        }).orElseThrow(() -> new RuntimeException("Marca no encontrada"));
    }

    @Override
    public Marca deleteMarca(Long id) {
        return marcaRepository.findById(id).map(marca -> {
            marca.setEstado(0); // Eliminación lógica
            return marcaRepository.save(marca);
        }).orElseThrow(() -> new RuntimeException("Marca no encontrada"));
    }
}
