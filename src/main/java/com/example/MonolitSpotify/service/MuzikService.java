package com.example.MonolitSpotify.service;

import com.example.MonolitSpotify.dto.request.AddMusicForArtistRequestDto;
import com.example.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.example.MonolitSpotify.dto.response.FindAllMuzikResponseDto;
import com.example.MonolitSpotify.mapper.MuzikMapper;
import com.example.MonolitSpotify.repository.MuzikRepository;
import com.example.MonolitSpotify.repository.entity.Muzik;
import com.example.MonolitSpotify.utility.enums.State;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikService {

    private final MuzikRepository repository;

    public void save(SaveMuzikRequestDto dto) {
//        Muzik muzik= Muzik.builder()
//                .muzikUrl(dto.getMuzikUrl())
//                .aciklama(dto.getAciklama())
//                .tur(dto.getTur())
//                .name(dto.getName())
//                .sure(dto.getSure())
//                .kapakResmi(dto.getKapakResmi())
//                .build();

//        Muzik muzik=new Muzik();
//        muzik.setMuzikUrl(dto.getMuzikUrl());
//        muzik.setName(dto.getName());


        Muzik muzik = MuzikMapper.INSTANCE.muzikFromDto(dto);
        muzik.setState(State.PENDING);
        repository.save(muzik);

//        repository.save(MuzikMapper.INSTANCE.muzikFromDto(dto));
//

    }

    public FindAllMuzikResponseDto findAll() {
        return FindAllMuzikResponseDto.builder()
                .statusCode(100)
                .message("Müzik Listesi Getirildi")
                .data(repository.findAll())
                .build();
    }

    /**
     * TODO 1-Kullanıcı id mevcut mu bakılmalı
     * TODO 2-Muzik id mevcut mu kontrol edilecek
     * TODO 3-Kullanıcı id si verilen kisi sanatci mi?Kontrol edilecek?
     * TODO 4-Eger aynı kullanici id ve müzik id daha önce kayit edilmisse tekrar kayit edilememelidir.
     *
     * @param dto
     */
    public void addMusicForArtist(AddMusicForArtistRequestDto dto) {
    }
}
