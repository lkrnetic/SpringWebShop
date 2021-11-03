package com.example.SpringBootWebShop.appuser;

import com.example.SpringBootWebShop.basket.Basket;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Table(name="app_user")
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class AppUser implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String country;
    private Integer zipCode;
    private String forgetPasswordToken;
    private String accountActivationToken;
    @Enumerated(EnumType.STRING)
    private AppUserRole userRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    @JsonManagedReference
    @OneToOne(mappedBy = "appUser")
    private Basket basket;

    public AppUser(String firstName, String lastName, String email, String password, String address, String phoneNumber, String country, Integer zipCode, AppUserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.zipCode = zipCode;
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }



}
