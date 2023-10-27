package com.example.MonolitSpotify.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    SIFRE_UYUSMUYOR(1001,"Girilen Sifreler Uyusmuyor",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(3001,"Girilen Bilgiler Hatali",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1004,"Girilen Kullanici Id Kayıtlı Değildir.",HttpStatus.BAD_REQUEST),
    MUSIC_NOT_FOUND(1005,"Girilen Music Idsi bulanamamistir.",HttpStatus.BAD_REQUEST),
    NO_ARTIST(1006,"Girilen Kullanıcı id si bir sanatciya ait degildir.",HttpStatus.BAD_REQUEST),
    ARTIST_ERROR(1007,"Sanatçı id si hatalidir.Lütfen tekrar kontrole saglayarak giriş yapınız.",HttpStatus.BAD_REQUEST),
    KAYITLI_KULLANICI_ADI(1003,"Bu kullanıcı adı zaten Kayıtlı",HttpStatus.BAD_REQUEST),
    KAYITLI_EMAIL(1004,"Bu email zaten mevcut",HttpStatus.BAD_REQUEST),
    TUR_ERROR(1002,"Muzik Turu Bulunamadi",HttpStatus.BAD_REQUEST);




    private int code;
    private String message;
    private HttpStatus httpStatus;

}
