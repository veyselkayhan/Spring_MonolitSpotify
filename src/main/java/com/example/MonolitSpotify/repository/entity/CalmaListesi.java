package com.example.MonolitSpotify.repository.entity;

import com.example.MonolitSpotify.utility.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_calmalistesi")
public class CalmaListesi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userProfileId;
    String baslik;
    int sarkiSayisi;
    @Enumerated(EnumType.STRING)
    State state;
}
