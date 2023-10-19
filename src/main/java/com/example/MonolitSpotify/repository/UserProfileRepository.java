package com.example.MonolitSpotify.repository;

import com.example.MonolitSpotify.repository.entity.UserProfile;
import com.example.MonolitSpotify.utility.enums.State;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
DİKKAT!!!

Spring 3.X ile birlikte Repository sınıfların üzerinde ekleme @Repository anatosyonu kaldırılmıştır.
 */

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
    /**
     *
     * Username->UserName->userName->kullanıcıAdı->kullanıcıadı
     *
     * Spring Data Jpa içindeki belli kelimelerlei analiz ederek doğru sıralamada kullanıldığı
     * sorgulamayı kelimelerle yapabiliyor.
     *
     * Kelimeleri kullanarak Sorgu yazma Syntax 'i
     *
     * 1-> [find] yazilir.
     * 2-> [By] yazilir."Belli" koşullarda araya başka keywordler gelebilir.
     * 3-> [Entity - Değişken Adı], Buraya Dikkat, değişken adlari büyük harf ile başlamali
     * 4->() parantez içine istediğiniz türdeki değişken ya da değişkenleri tanımlıyoruz.
     *
     *
     *
     */

    UserProfile findByResimUrl(String resimUrl);

   // Optional<UserProfile> findOptionalByUserName(String userName);

    //Select * from tbl_userprofile where state=?
    List<UserProfile> findAllByState(State state);

    /**
     *
     * Belli bir tarih aralığında kayıt olanları bulalım
     *
     * Son 30 günde kayit olanlarin listesi
     *
     * GreaterThan -> bundan büyük -> createAt >xxx
     *
     * LessThan->Bundan kücük -> createAt <xxx
     *
     * GreaterThanEquals-> createAt >= xxx
     * LessThanEquals-> createAt <= xxx
     *
     */

    List<UserProfile> findAllByCreateAtGreaterThan(Long kayitZamani);

    /**
     * Select * FROM tbl_userprofile where username like '%muh%'
     *
     * DİKKAT!!!
     *
     * burada username ile parametre gönderirken gelen değere spring % ya da _ gibi
     * operatörleri eklemez.Bu nedenle sorgu yaparken şu şekilde kullanın
     *
     * ->findAllByUserNameLike("%muh%")
     */

    List<UserProfile> findAllByUserNameLike(String username);


    /**
     *
     * SELECT * FROM tbl_userprofile where username = muh%
     */

    List<UserProfile>findAllByUserNameStartingWith(String userName);

    /**
     * Select * From tbl_userprofile where createAt > XXX and username like 'muh%'
     *
     * LastDate and öncesine
     * UserName and sonrasına setlendi.
     * and veya or yazılabilir.İkiside uygundur dedi fakat araştır.
     *
     */

    List<UserProfile> findAllByCreateAtGreaterThanAndUserNameLike(Long lastDate,String userName);


    /**
     * Optional eğer tek sonuc dönmeyi hedefliyor iseniz.Mutlaka ve mutlaka optional kullanın
     * Çünkü aradığınız parametre her zaman doğru girilmiyor olabilir Bu sebepten null gelebilir.
     * Bunun için null check yapmanız lazım
     *
     * Eğer amaç sadece entity ise optional dönün .
     */

    Optional<UserProfile>findByUserName (String userName);

    /**
     *
     * Sıralama çok önemli olabiliyor.A-Z ye veya nümerik gibi
     *
     * Normalde
     * !!Order'ın default u küçükten büyüğe
     *
     * ASC -> A.....Z
     * DESC -> Z....A
     *
     * Select * From tbluserprofile order by createAt
     *
     */

    List<UserProfile>findAllByOrderByCreateAt();

    List<UserProfile>findAllByOrderByCreateAtDesc();

    /**
     *
     * Belli kayıtlrın öncelenerek cekilmesi ya da kayıtlardan kısıtlamaya gidilmesi
     * Listelenirken performans sağlar ve çok daha anlamlıdır.
     */

    List<UserProfile> findTop3By();

    List<UserProfile> findTop10ByOrderByCreateAtDesc();


    UserProfile findTopByOrderByCreateAtDesc();

    Optional<UserProfile> findTopOptionalByOrderByCreateAtDesc();

    /**
     *
     * Belli aralıklarda kısıtlamaya gidebiliriz.Bunun için and ile birleştirme yapabiliriz.
     * ancak Spring data bunun için bize bir kolaylık sağlıyor.
     * Uyelik tarihi 1 ile 2 yıl arasında alanları getir.
     *
     */

    List<UserProfile> findAllByCreateAtBetween(Long start,Long end);

    List<UserProfile> findAllByUserNameLikeAndCreateAtBetween(String userName,Long start,Long end);

    /**
     *
     * ->isActive = true/false
     *
     *
     * List<UserProfile> findAllByIsActiveTrue();
     * List<UserProfile> findAllByIsActive(boolean isActive);
     *
     */

    /**
     *
     * Bir alanı sorgularken eşitlik için ek bir kodlama yapmaya gerek yoktur.Ancak bazen girilen
     * değer ile tutulmuş olan değer büyük küçük harf sorununa takılabiliyor.Bunun için bu işlemi
     * ignore etmek gereklidir.
     */

    Optional<UserProfile> findOptionalByUserNameIgnoreCase(String userName);

    /**
     * Bazı Kolonlar belki daha sonra doldurulmak üzere boş bırakabiliriz.Bu nedenle kontrol
     * etmek ve kullanıcıya bunları doldurası yönünde telkinde bulunabilir.
     *
     * Null,IsNull,NotNull,
     */

    List<UserProfile>findAllByResimUrlIsNull();






}
