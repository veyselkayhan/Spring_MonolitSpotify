package com.example.MonolitSpotify.controller;

import com.example.MonolitSpotify.repository.entity.UserProfile;
import com.example.MonolitSpotify.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userprofile")
@RequiredArgsConstructor
public class UserProfileController {


    private final UserProfileService userProfileService;


    @PostMapping("/save")
    public ResponseEntity<UserProfile>save(String userName,String  name,String email,String phone){
        UserProfile userProfil=UserProfile.builder()
                .userName(userName)

                .build();
        userProfileService.save(userProfil);
        return ResponseEntity.ok(userProfil);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }


}
