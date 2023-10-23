package com.example.MonolitSpotify.dto.response;

import com.example.MonolitSpotify.repository.entity.Muzik;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FindAllMuzikResponseDto {
    int statusCode;
    String message;
    List<Muzik>data;
}
