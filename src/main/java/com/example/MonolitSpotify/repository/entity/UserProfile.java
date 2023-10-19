package com.example.MonolitSpotify.repository.entity;


import com.example.MonolitSpotify.utility.enums.State;
import com.example.MonolitSpotify.utility.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_userprofile")

public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String resimUrl;
    int followerCount;
    int followingCount;
    Long createAt;
    Long updateAt;

    @Enumerated(EnumType.STRING)
    UserType userType;

    State state;


}
