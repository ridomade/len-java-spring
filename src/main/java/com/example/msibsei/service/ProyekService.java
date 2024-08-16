package com.example.msibsei.service;

import com.example.msibsei.entity.Proyek;
import com.example.msibsei.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    public Proyek addProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    public Proyek getProyekById(Long id) {
        return proyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek not found"));
    }
    
    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Proyek updateProyek(Long id, Proyek proyekDetails) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek not found"));

        proyek.setNamaProyek(proyekDetails.getNamaProyek());
        proyek.setClient(proyekDetails.getClient());
        proyek.setTglMulai(proyekDetails.getTglMulai());
        proyek.setTglSelesai(proyekDetails.getTglSelesai());
        proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
        proyek.setKeterangan(proyekDetails.getKeterangan());

        return proyekRepository.save(proyek);
    }

    public void deleteProyek(Long id) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek not found"));
        proyekRepository.delete(proyek);
    }
}
