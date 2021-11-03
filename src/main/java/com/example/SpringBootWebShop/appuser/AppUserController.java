package com.example.SpringBootWebShop.appuser;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/users")
@AllArgsConstructor
public class AppUserController {
    private final AppUserServiceImpl appUserServiceImpl;

    @PutMapping("/{id}")
    public String editUser(@RequestBody AppUserRequest request, @PathVariable Long id) {
        //return appUserServiceImpl.editUser(request);
        return String.valueOf(request.getAddress());
    }

    @PostMapping
    public AppUser createUser(@RequestBody AppUserRequest request) {
        return appUserServiceImpl.createUser(request);
    }
}
