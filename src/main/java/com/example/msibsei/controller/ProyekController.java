package com.example.msibsei.controller;

import com.example.msibsei.entity.Proyek;
import com.example.msibsei.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @PostMapping
    public ResponseEntity<Proyek> addProyek(@RequestBody Proyek proyek) {
        proyek.setTglMulai(LocalDate.parse(proyek.getTglMulai().toString(), DATE_FORMATTER));
        proyek.setTglSelesai(LocalDate.parse(proyek.getTglSelesai().toString(), DATE_FORMATTER));
        Proyek newProyek = proyekService.addProyek(proyek);
        return ResponseEntity.ok(newProyek);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyek> getProyekById(@PathVariable Long id) {
        Proyek proyek = proyekService.getProyekById(id);
        return ResponseEntity.ok(proyek);
    }


    @GetMapping
    public ResponseEntity<List<Proyek>> getAllProyek() {
        List<Proyek> proyekList = proyekService.getAllProyek();
        return ResponseEntity.ok(proyekList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Long id, @RequestBody Proyek proyekDetails) {
        proyekDetails.setTglMulai(LocalDate.parse(proyekDetails.getTglMulai().toString(), DATE_FORMATTER));
        proyekDetails.setTglSelesai(LocalDate.parse(proyekDetails.getTglSelesai().toString(), DATE_FORMATTER));
        Proyek updatedProyek = proyekService.updateProyek(id, proyekDetails);
        return ResponseEntity.ok(updatedProyek);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable Long id) {
        proyekService.deleteProyek(id);
        return ResponseEntity.ok().build();
    }
}
