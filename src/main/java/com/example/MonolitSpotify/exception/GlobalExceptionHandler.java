package com.example.MonolitSpotify.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (MonolitSpotifyException.class)//bu sınıf bütün uygulamayı exception için dinler
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleMonolitSpotifyException(MonolitSpotifyException exception){
        return ResponseEntity.ok(ErrorMessage.builder()
                        .code(exception.getErrorType().getCode())
                        .message(exception.getErrorType().getMessage())
                        .build());
    }
}
