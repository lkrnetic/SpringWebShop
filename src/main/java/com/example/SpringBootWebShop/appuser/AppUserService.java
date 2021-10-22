package com.example.SpringBootWebShop.appuser;

public interface AppUserService {

    String signUpUser(RegistrationRequest request);

    AppUser findByEmail(String email);
}
