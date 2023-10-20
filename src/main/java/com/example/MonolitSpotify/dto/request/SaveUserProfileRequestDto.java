package com.example.MonolitSpotify.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveUserProfileRequestDto {
    @NotBlank(message = "Kullanıcı Adını Boş Gecemezsiniz")
    @Size(min = 3,max = 64)
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{3,}$",
            message = "Kullanıcı Adı için Sadece kücük harf ve rakam girebilirsiniz"

    )
    String userName;
    @Email(message = "Lütfen Gecerli Bir email adresi girin")
    String email;
    @Size(min = 8,max = 128)
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.,?@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Şifrede 1 adet Büyük Harf 1 adet Kücük Harf 1 Adet Rakam 1 adet Ozel Karakter içermelidir."
    )
    String password;
    String rePassword;
}
