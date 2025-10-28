package com.ecommerce.essenza.services;

import com.ecommerce.essenza.models.Perfume;
import com.ecommerce.essenza.repositories.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfumeServiceImpl implements PerfumeService {

    @Autowired
    private PerfumeRepository perfumeRepository;


    @Override
    public List<Perfume> getAllPerfumes() {
        return perfumeRepository.findAll();
    }

    @Override
    public Optional<Perfume> getPerfumeById(Long id) {
        return perfumeRepository.findById(id);
    }

    @Override
    public Perfume savePerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    @Override
    public Perfume updatePerfume(Long id, Perfume perfumeDetails) {
        return perfumeRepository.findById(id).map(perfume -> {
            perfume.setNombre(perfumeDetails.getNombre());
            perfume.setDescripcion(perfumeDetails.getDescripcion());
            perfume.setPrecioOriginal(perfumeDetails.getPrecioOriginal());
            perfume.setPrecioActual(perfumeDetails.getPrecioActual());
            perfume.setDescuento(perfumeDetails.getDescuento());
            perfume.setStock(perfumeDetails.getStock());
            perfume.setImagenUrl(perfumeDetails.getImagenUrl());
            perfume.setFechaCreacion(perfumeDetails.getFechaCreacion());
            perfume.setEstado(perfumeDetails.getEstado());
            perfume.setCategoria(perfumeDetails.getCategoria());
            perfume.setGenero(perfumeDetails.getGenero());
            perfume.setMarca(perfumeDetails.getMarca());
            return perfumeRepository.save(perfume);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Perfume deletePerfume(Long id) {
        return perfumeRepository.findById(id).map(perfume -> {
            perfume.setEstado(0); // Eliminación lógica
            return perfumeRepository.save(perfume);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public List<Perfume>  buscarPorNombre(String nombre) {
        return perfumeRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Perfume> findByCategoriaId(Long id) {
        return perfumeRepository.findByCategoriaId(id);
    }

    @Override
    public List<Perfume> findByGeneroId(Long id) {
        return perfumeRepository.findByGeneroId(id);
    }

    @Override
    public List<Perfume> findByMarcaId(Long id ) {
        return perfumeRepository.findByMarcaId(id);
    }

    @Override
    public List<Perfume> findByCategoriaIdAndGeneroIdAndMarcaId(Long categoriaId, Long generoId, Long marcaId) {
        if (categoriaId != null && generoId != null && marcaId != null) {
            return perfumeRepository.findByCategoriaIdAndGeneroIdAndMarcaId(categoriaId, generoId, marcaId);
        } else if (categoriaId != null) {
            return perfumeRepository.findByCategoriaId(categoriaId);
        } else if (generoId != null) {
            return perfumeRepository.findByGeneroId(generoId);
        } else if (marcaId != null) {
            return perfumeRepository.findByMarcaId(marcaId);
        }
        return perfumeRepository.findAll();
    }

}


