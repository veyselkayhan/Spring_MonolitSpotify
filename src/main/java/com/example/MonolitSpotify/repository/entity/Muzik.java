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
@Table(name = "tbl_muzik")
public class Muzik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String muzikUrl;
    String name;
    String kapakResmi;
    /**
     *  TODO Muzik türü tablosundan doğrulandıktan sonra girişine onay var
     */
    String tur;
    int sure;
    String aciklama;

    @Enumerated(EnumType.STRING)
    State state;

}
