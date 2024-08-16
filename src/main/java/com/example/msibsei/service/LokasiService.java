package com.example.msibsei.service;

import com.example.msibsei.entity.Lokasi;
import com.example.msibsei.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public Lokasi addLokasi(Lokasi lokasi) {
        if (lokasi.getCreatedAt() == null) {
            lokasi.setCreatedAt(LocalDateTime.now()); 
        }
        return lokasiRepository.save(lokasi);
    }

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }
    public Lokasi getLokasiById(Long id) {
        return lokasiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lokasi not found"));
    }
    
    public Lokasi updateLokasi(Long id, Lokasi lokasiDetails) {
        Lokasi lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lokasi not found"));
    
        lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
        lokasi.setNegara(lokasiDetails.getNegara());
        lokasi.setProvinsi(lokasiDetails.getProvinsi());
        lokasi.setKota(lokasiDetails.getKota());
    
        return lokasiRepository.save(lokasi);
    }

    public void deleteLokasi(Long id) {
        Lokasi lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lokasi not found"));
        lokasiRepository.delete(lokasi);
    }
}
