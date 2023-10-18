package com.example.MonolitSpotify.repository;

import com.example.MonolitSpotify.repository.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
DÝKKAT!!!

Spring 3.X ile birlikte Repository sýnýflarýn üzerinde ekleme @Repository anatosyonu kaldýrýlmýþtýr.
 */

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

}
