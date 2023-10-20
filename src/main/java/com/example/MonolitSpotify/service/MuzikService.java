package com.example.MonolitSpotify.service;

import com.example.MonolitSpotify.repository.MuzikRepository;
import com.example.MonolitSpotify.repository.entity.Muzik;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikService {

    private final MuzikRepository repository;

    public void save(Muzik entity){
        repository.save(entity);
    }
}
