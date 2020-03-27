package ru.FogStreamBackEnd.FSBe.model;

//import org.springframework.security.core.GrantedAuthority;

public enum Role { //implements GrantedAuthority
    ROLE_USER,
    ROLE_ADMIN;
/*

    @Override
    public String getAuthority() {
        return name();
    }
*/
}