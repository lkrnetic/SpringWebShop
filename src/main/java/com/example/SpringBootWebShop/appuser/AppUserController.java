package com.example.SpringBootWebShop.appuser;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/users")
@AllArgsConstructor
public class AppUserController {
    private final AppUserServiceImpl appUserServiceImpl;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return appUserServiceImpl.signUpUser(request);
    }
}
