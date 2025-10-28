package com.ecommerce.essenza.controllers;


import com.ecommerce.essenza.models.Genero;
import com.ecommerce.essenza.models.Marca;
import com.ecommerce.essenza.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/marcas")
public class MarcaController {


    @Autowired
    private MarcaService marcaService;


    @GetMapping
    public ResponseEntity<List<Marca>> getAllMarcas() {
        ResponseEntity<List<Marca>> ok = ResponseEntity.ok(marcaService.getAllMarcas());
        return ok;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable Long id) {
        return marcaService.getMarcaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Marca> saveMarca(@RequestBody Marca marca) {
        return ResponseEntity.ok(marcaService.saveMarca(marca));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable Long id, @RequestBody Marca marca) {
        try {
            Marca updated =  marcaService.updateMarca(id, marca);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Marca> deleteMarca(@PathVariable Long id) {
        try {
            Marca deleted = marcaService.deleteMarca(id);
            return ResponseEntity.ok(deleted);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
