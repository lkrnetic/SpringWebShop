package com.example.SpringBootWebShop.appuser;

public interface AppUserService {

    AppUser createUser(AppUserRequest request);

    AppUser findByEmail(String email);
    AppUser getById(Long id);

}
