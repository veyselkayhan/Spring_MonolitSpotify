package com.example.MonolitSpotify.repository.entity;

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
@Table(name = "tbl_muzik_sanatci")
public class MuzikSanatci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sanatciId;
    Long muzikId;

}
