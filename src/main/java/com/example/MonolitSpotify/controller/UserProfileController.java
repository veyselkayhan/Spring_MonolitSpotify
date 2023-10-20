package com.example.MonolitSpotify.controller;

import com.example.MonolitSpotify.constants.RestApi;
import com.example.MonolitSpotify.dto.request.SaveUserProfileRequestDto;
import com.example.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.example.MonolitSpotify.repository.entity.UserProfile;
import com.example.MonolitSpotify.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.MonolitSpotify.constants.RestApi.*;

import java.util.List;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor

public class UserProfileController {


    private final UserProfileService userProfileService;


//    @PostMapping(SAVE)
//    public ResponseEntity<UserProfile>save(String userName,String  name,String email,String phone){
//        UserProfile userProfil=UserProfile.builder()
//                .userName(userName)
//
//                .build();
//        userProfileService.save(userProfil);
//        return ResponseEntity.ok(userProfil);
//    }

//    @GetMapping(FINDALL)
//    public ResponseEntity<List<UserProfile>> findAll(){
//        return ResponseEntity.ok(userProfileService.findAll());
//    }

    @PostMapping(SAVE)
    public ResponseEntity<Void>saveUserProfile(@RequestBody @Valid SaveUserProfileRequestDto dto){
        userProfileService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<FindAllUserProfileResponseDto>>findAllUserProfile(){
        return ResponseEntity.ok(userProfileService.findAllUserProfile());
    }


}
