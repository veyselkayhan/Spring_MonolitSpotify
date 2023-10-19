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
@Table(name = "tbl_muzikturu")
public class MuzikTuru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String tur;
    @Enumerated(EnumType.STRING)
    State state;

}
