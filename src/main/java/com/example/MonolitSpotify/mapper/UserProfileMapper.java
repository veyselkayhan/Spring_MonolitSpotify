package com.example.MonolitSpotify.mapper;

import com.example.MonolitSpotify.dto.request.SaveUserProfileRequestDto;
import com.example.MonolitSpotify.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileMapper {
    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    UserProfile userProfileFromDto(SaveUserProfileRequestDto dto);

    SaveUserProfileRequestDto toDto_MethodAdi(UserProfile userProfile);
}
