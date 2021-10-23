package com.example.SpringBootWebShop.appuser;

import java.util.Optional;

public interface AppUserService {

    String signUpUser(RegistrationRequest request);

    AppUser findByEmail(String email);
    AppUser getById(Long id);

}
