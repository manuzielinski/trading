package com.manudev.Trading.userService.config.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class JwtProvider {

    @Value("${security.jwt.key.private}")
    private String privateKey;

    public static String generateToken(Authentication auth) {
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        String roles
    }

    public static String populateAuthorities(Collection<? extends GrantedAuthority>)
}
