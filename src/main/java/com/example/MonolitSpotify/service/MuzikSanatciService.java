package com.example.MonolitSpotify.service;


import com.example.MonolitSpotify.repository.MuzikSanatciRepository;
import com.example.MonolitSpotify.repository.entity.MuzikSanatci;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class MuzikSanatciService {

    private final MuzikSanatciRepository repository;

    public void save(MuzikSanatci entity){
        repository.save(entity);
    }
}
