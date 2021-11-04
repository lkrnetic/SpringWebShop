package com.example.SpringBootWebShop.appuser;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        AppUser appUser = null;
        Map<String, Object> response = new HashMap<>();
        try {
            appUser = appUserServiceImpl.getById(id);
        } catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (appUser == null) {
            response.put("message", "User with ID: ".concat(id.toString().concat(" doesn't exist in database.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>  createUser(@RequestBody AppUserRequest request) {
        AppUser appUser = appUserServiceImpl.findByEmail(request.getEmail());
        Map<String, Object> response = new HashMap<>();
        if (appUser != null) {
            response.put("message", "There is already user with email that was entered.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
        }
        try {
            appUser = appUserServiceImpl.createUser(request);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "User was created successfully.");
        response.put("user", appUser);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }
}
