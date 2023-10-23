package com.example.MonolitSpotify.mapper;

import com.example.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.example.MonolitSpotify.repository.entity.Muzik;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * ComponentModel-> Mapper in bu sınıftan bir nesne yaratmakla ilgili yapısının spring model şeklinde
 * olduğunu belirtiyoruz.
 * unmappedTargetPolicy->Eğer atama yapılacak olan sınıf içindeki alanlar kaynak nesne ile uyusmuyor
 * ise hata vermemesi uyusmayan alanları ignore etmesi(null geçmesi) için kullanılır.
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MuzikMapper {
    /**
     * İlgili sınıftan bir impl yaratarak nesnenin referansını INSTANCE a atar.Yani size bir nesne döner.
     *
     */
    MuzikMapper INSTANCE= Mappers.getMapper(MuzikMapper.class);

    Muzik muzikFromDto(final SaveMuzikRequestDto dto);



}
