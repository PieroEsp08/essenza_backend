package com.ecommerce.essenza.controllers;

import com.ecommerce.essenza.models.Perfume;
import com.ecommerce.essenza.services.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/perfumes")
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    // List all perfumes
    @GetMapping
    public ResponseEntity<List<Perfume>> getAllPerfumes() {
        return ResponseEntity.ok(perfumeService.getAllPerfumes());
    }

    // Get a perfume by ID
    @GetMapping("/{id}")
    public ResponseEntity<Perfume> getPerfumeById(@PathVariable Long id) {
        return perfumeService.getPerfumeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new perfume
    @PostMapping
    public ResponseEntity<Perfume> savePerfume(@RequestBody Perfume perfume) {
        return ResponseEntity.ok(perfumeService.savePerfume(perfume));
    }

    // Update an existing perfume
    @PutMapping("/{id}")
    public ResponseEntity<Perfume> updatePerfume(@PathVariable Long id, @RequestBody Perfume perfume) {
        try {
            Perfume updated = perfumeService.updatePerfume(id, perfume);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Logical delete of perfume (set estado = 0)
    @DeleteMapping("/{id}")
    public ResponseEntity<Perfume> deletePerfume(@PathVariable Long id) {
        try {
            Perfume deleted = perfumeService.deletePerfume(id);
            return ResponseEntity.ok(deleted);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Perfume>> buscarPerfumes(@RequestParam String nombre) {
        return ResponseEntity.ok(perfumeService.buscarPorNombre(nombre));
    }

    // Filter by category
    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Perfume>> getByCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(perfumeService.findByCategoriaId(id));
    }

    // Filter by gender
    @GetMapping("/genero/{id}")
    public ResponseEntity<List<Perfume>> getByGenero(@PathVariable Long id) {
        return ResponseEntity.ok(perfumeService.findByGeneroId(id));
    }

    // Filter by brand
    @GetMapping("/marca/{id}")
    public ResponseEntity<List<Perfume>> getByMarca(@PathVariable Long id) {
        return ResponseEntity.ok(perfumeService.findByMarcaId(id));
    }

    // Combined filtering (category + gender + brand)
    @GetMapping("/filter")
    public ResponseEntity<List<Perfume>> filterPerfumes(
            @RequestParam(required = false) Long categoriaId,
            @RequestParam(required = false) Long generoId,
            @RequestParam(required = false) Long marcaId
    ) {
        return ResponseEntity.ok(perfumeService.findByCategoriaIdAndGeneroIdAndMarcaId(categoriaId, generoId, marcaId));
    }


}
