package com.example.MonolitSpotify.service;

import com.example.MonolitSpotify.repository.CalmaListesiMuzikRepository;
import com.example.MonolitSpotify.repository.entity.CalmaListesiMuzik;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalmaListesiMuzikService {

    private final CalmaListesiMuzikRepository repository;

    public void save(CalmaListesiMuzik entity){
        repository.save(entity);
    }
}
