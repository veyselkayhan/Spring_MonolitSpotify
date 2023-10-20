package com.example.MonolitSpotify.service;

import com.example.MonolitSpotify.repository.FollowRepository;
import com.example.MonolitSpotify.repository.entity.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService   {

    private final FollowRepository repository;

    public void save(Follow follow){
        repository.save(follow);
    }
}
