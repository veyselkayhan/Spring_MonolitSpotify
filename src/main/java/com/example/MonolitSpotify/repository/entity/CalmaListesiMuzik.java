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
@Table(name = "tbl_calmalistesi_muzik")
public class CalmaListesiMuzik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long muzikId;
    Long calmaListesiId;
    @Enumerated(EnumType.STRING)
    State state;


}
