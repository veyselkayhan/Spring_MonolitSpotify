package com.example.MonolitSpotify.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SaveMuzikRequestDto {
    @NotNull         //muzik url tanımlı olarak gelmemiş ise
    @NotBlank        //tanımlı fakat içine hiçbir şey yazmamıştır.
    String muzikUrl;
    @NotNull
    @NotBlank
    String name;
    String kapakResmi;
    @NotNull
    @NotBlank
    String tur;
    int sure;
    String aciklama;

}
