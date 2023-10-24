package com.example.MonolitSpotify.service;


import com.example.MonolitSpotify.dto.request.SaveUserProfileRequestDto;
import com.example.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.example.MonolitSpotify.exception.ErrorType;
import com.example.MonolitSpotify.exception.MonolitSpotifyException;
import com.example.MonolitSpotify.repository.UserProfileRepository;
import com.example.MonolitSpotify.repository.entity.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
Dikkat!!
servis sınıflarının belirtilmesi ve bunlardan birer Bean olusturulmasi için spring bu sınıflarin üzerinde
@Service anatasyonu olup olmadığına bakar.Eğer boş geçilirse hata fırlatır.Uygulamamız ayağa kalkmaz..
 */
@Service
public class UserProfileService {

    /**
    DİKKAT!!!
    Spring Bean olarak işaretlediği (@Repository,@Service,@Configuration,@Component v.s.)
    Tüm sınıflardan nesne yaratabilmek için 3 farklı yöntem izler.
    1-Değişkenin üzerinde @Autowired eklenecek(newleme işlemini bununla yapar).
    2-Değişkenin constructor a paramatre alarak gecilmesi ile yapılır.(Constructor Injection)
    3-2. yöntem in 3.taraf uygulamalar ile sağlanması.yazımı daha kolaydır.Kod sayfasının
    daha temiz görünmesini sağlar.
     */

//    @Autowired
//    private UserProfileRepository repositoryYöntem_1;
//
//    private UserProfileRepository repositoryYöntem_2;
//
//    public UserProfileService(UserProfileRepository repositoryYöntem_2){
//        this.repositoryYöntem_2=repositoryYöntem_2;
//
//    }

    public UserProfileService(UserProfileRepository repository) {
        this.repository = repository;
    }
    private final UserProfileRepository repository;


    /**
     * Onemli !!!
     * save işlemi iki sekilde çalışır.
     *
     * 1-Eğer kendisine verilen nesne id bilgisini içermiyor ise
     * yani null ise kaydetme işlemi yapar.
     * 2-Eğer nesne içindeki id bir değer içeriyor ise bu seferde güncelleme işlemi
     * yapar.
     *
     */

    public void save(SaveUserProfileRequestDto dto){
        if(!(dto.getPassword().equals(dto.getRePassword()))) {
            throw new MonolitSpotifyException(ErrorType.SIFRE_UYUSMUYOR);
        }
        repository.save(
                UserProfile.builder().userName(dto.getUserName())
                        .build()
                );
    }

    public void save(UserProfile userProfile){
        repository.save(userProfile);

    }
    public List<UserProfile> findAll(){
        return repository.findAll();
    }

    public FindAllUserProfileResponseDto findAllUserProfile() {
        return FindAllUserProfileResponseDto.builder()
                .httpStatusCode(100)
                .message("Listeler Başarılı bir şekilde çekildi")
                .data(repository.findAllFromUserProfileView())
                .build();
    }
}
