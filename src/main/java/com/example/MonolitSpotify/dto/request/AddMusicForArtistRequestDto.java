package com.example.MonolitSpotify.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AddMusicForArtistRequestDto {
    @NotNull
    @Min(1)
    Long musicId;
    @NotNull
    @Min(1)
    Long artistId;


}
