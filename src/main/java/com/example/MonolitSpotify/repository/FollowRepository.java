package com.example.MonolitSpotify.repository;

import com.example.MonolitSpotify.repository.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow,Long> {
}
