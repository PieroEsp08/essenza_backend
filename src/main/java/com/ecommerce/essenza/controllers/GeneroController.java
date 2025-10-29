package com.ecommerce.essenza.controllers;

import com.ecommerce.essenza.models.Genero;
import com.ecommerce.essenza.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/generos")
public class GeneroController {


    @Autowired
    private GeneroService generoService;


    @GetMapping
    public ResponseEntity<List<Genero>> getAllGeneros() {
        return ResponseEntity.ok(generoService.getAllGeneros());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable Long id) {
        return generoService.getGeneroById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Genero> saveGenero(@RequestBody Genero genero) {
        return ResponseEntity.ok(generoService.saveGenero(genero));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Genero> updateGenero(@PathVariable Long id, @RequestBody Genero genero) {
        try {
            Genero updated = generoService.updateGenero(id, genero);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Genero> deleteGenero(@PathVariable Long id) {
        try {
            Genero deleted = generoService.deleteGenero(id);
            return ResponseEntity.ok(deleted);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
