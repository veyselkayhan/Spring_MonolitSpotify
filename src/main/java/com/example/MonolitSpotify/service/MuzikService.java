package com.example.MonolitSpotify.service;

import com.example.MonolitSpotify.dto.request.AddMusicForArtistRequestDto;
import com.example.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.example.MonolitSpotify.dto.response.FindAllMuzikResponseDto;
import com.example.MonolitSpotify.exception.ErrorType;
import com.example.MonolitSpotify.exception.MonolitSpotifyException;
import com.example.MonolitSpotify.mapper.MuzikMapper;
import com.example.MonolitSpotify.repository.MuzikRepository;
import com.example.MonolitSpotify.repository.MuzikSanatciRepository;
import com.example.MonolitSpotify.repository.entity.Muzik;
import com.example.MonolitSpotify.repository.entity.MuzikSanatci;
import com.example.MonolitSpotify.repository.entity.UserProfile;
import com.example.MonolitSpotify.utility.enums.State;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuzikService {

    private final MuzikRepository repository;

    private final UserProfileService userProfileService;

    private final MuzikSanatciRepository muzikSanatciRepository;


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
        if (!userProfileService.existById(dto.getArtistId()) || !userProfileService.isArtist(dto.getArtistId()))
            throw new MonolitSpotifyException(ErrorType.ARTIST_ERROR);
        else if (!repository.existsById(dto.getMusicId()))
            throw new MonolitSpotifyException(ErrorType.MUSIC_NOT_FOUND);
        muzikSanatciRepository.save(MuzikSanatci.builder()
                .muzikId(dto.getMusicId())
                .sanatciId(dto.getArtistId())
                .build());
    }


    /**
     * TODO:1- ArtistId sini kullanarak (UserProfileId si) kullanarak tbl_muziksanatci tablosundan ilgili id ye ait tüm kayitlar çekilir.
     * TODO:2-tbl_muziksanatci tablosundan gelen tüm kayıtlarin içinde müzik id leri bir liste içine atar.
     * TODO:3-müzik id leri bilinen liste muzikRepository e verilerek tüm müzik listesi çekilir.
     * TODO bir Query yazılarak aynı işlem tanımlanabilir.
     * @param id
     * @return
     */
    public List<Muzik> findAllMuzikFromArtistId(Long id) {
        List<MuzikSanatci> muzikSanatciList= muzikSanatciRepository.findAllBySanatciId(id);
        List<Long> muzikIds=muzikSanatciList.stream().map(MuzikSanatci::getMuzikId).toList();
        return repository.findAllById(muzikIds);
    }
}
