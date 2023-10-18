package com.example.MonolitSpotify.repository;

import com.example.MonolitSpotify.repository.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
D�KKAT!!!

Spring 3.X ile birlikte Repository s�n�flar�n �zerinde ekleme @Repository anatosyonu kald�r�lm��t�r.
 */

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

}
