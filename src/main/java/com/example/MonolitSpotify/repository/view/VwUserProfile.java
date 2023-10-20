package com.example.MonolitSpotify.repository.view;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class VwUserProfile {

    Long id;

    String userName;

    String resimUrl;
}
