package com.example.MonolitSpotify.service;

import com.example.MonolitSpotify.repository.MuzikTuruRepository;
import com.example.MonolitSpotify.repository.entity.MuzikTuru;
import com.example.MonolitSpotify.utility.manager.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikTuruService {

    private final MuzikTuruRepository repository;

//    public MuzikTuruService(MuzikTuruRepository repository){
//        super(repository);
//        this.repository=repository;
//    }



}
