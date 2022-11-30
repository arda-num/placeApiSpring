package com.example.placeapi.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomUserDetail implements UserDetails {

    private String username;

    private String password;
    private String name;
    private String familyName;
    private Integer age;
    private List<GrantedAuthority> authorities;


    public CustomUserDetail(String username, String password, String name, String familyName, Integer age, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public static CustomUserDetail build(Customer user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new CustomUserDetail(
                user.getUsername(),
                user.getUserPassword(),
                user.getName(),
                user.getFamilyName(),
                user.getAge(),
                authorities);
    }

}