package com.example.SpringBootWebShop.appuser;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/users")
@AllArgsConstructor
public class AppUserController {
    private final AppUserServiceImpl appUserServiceImpl;

    @PutMapping("/{id}")
    public String editUser(@RequestBody RegistrationRequest request, @PathVariable Long id) {
        //return appUserServiceImpl.editUser(request);
        return String.valueOf(request.getAddress());
    }

    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest request) {
        return appUserServiceImpl.signUpUser(request);
    }
}
