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
    TUR_ERROR(1002,"Muzik Turu Bulunamadi",HttpStatus.BAD_REQUEST),
    KAYITLI_KULLANICI_ADI(1003,"Bu kullanıcı adı zaten Kayıtlı",HttpStatus.BAD_REQUEST),
    KAYITLI_EMAIL(1004,"Bu email zaten mevcut",HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus httpStatus;

}
