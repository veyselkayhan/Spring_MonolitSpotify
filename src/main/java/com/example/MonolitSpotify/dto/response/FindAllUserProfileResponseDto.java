package com.example.MonolitSpotify.dto.response;

import com.example.MonolitSpotify.repository.view.VwUserProfile;
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
public class FindAllUserProfileResponseDto {
    int httpStatusCode;
    String message;
    int currentPage;
    boolean hasNext;
    List<VwUserProfile> data;

}
