package com.example.MonolitSpotify.controller;

import static com.example.MonolitSpotify.constants.RestApi.*;

import com.example.MonolitSpotify.dto.request.AddMusicForArtistRequestDto;
import com.example.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.example.MonolitSpotify.dto.response.FindAllMuzikResponseDto;
import com.example.MonolitSpotify.service.MuzikService;
import com.example.MonolitSpotify.service.MuzikTuruService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Muzik)
@RequiredArgsConstructor
public class MuzikController {
    private final MuzikService muzikService;
    @PostMapping(SAVE)
    public ResponseEntity<Void>saveMuzik(@RequestBody @Valid SaveMuzikRequestDto dto){
        muzikService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDALL)
    public ResponseEntity<FindAllMuzikResponseDto>findAll(){
        return ResponseEntity.ok(muzikService.findAll());
    }
    @PostMapping(ADDMUSICFORARTIST)
    public ResponseEntity<Void>addMusicForArtist(@RequestBody @Valid AddMusicForArtistRequestDto dto){
        muzikService.addMusicForArtist(dto);
        return ResponseEntity.ok().build();

    }


}
