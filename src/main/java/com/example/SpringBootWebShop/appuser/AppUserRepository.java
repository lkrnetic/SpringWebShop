package com.example.SpringBootWebShop.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser getById(Long id);
    AppUser findByEmail(String email);
    AppUser findByForgetPasswordToken(String forgetPasswordToken);
    AppUser findByAccountActivationToken(String accountActivationToken);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.password = ?2 WHERE a.email = ?1")
    int updatePassword(String email, String password);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.forgetPasswordToken = ?2 WHERE a.email = ?1")
    int updateForgetPasswordToken(String email, String forgetPasswordToken);


}