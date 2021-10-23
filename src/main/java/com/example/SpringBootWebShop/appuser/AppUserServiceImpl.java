package com.example.SpringBootWebShop.appuser;

import com.example.SpringBootWebShop.validation.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
;import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements UserDetailsService, AppUserService{
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmailValidator emailValidator;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /*
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
        */
        return appUserRepository.findByEmail(email);
    }

    public String signUpUser(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        AppUser appUser = new AppUser(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(), request.getAddress(), request.getPhoneNumber(), request.getCountry(), request.getZipCode(), AppUserRole.USER);
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);
        return "User is saved!";
    }


    @Override
    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public AppUser getById(Long id) {
        return appUserRepository.getById(id);
    }

}
