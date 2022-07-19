package com.ngs.authorization.config;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication newAuthentication = super.authenticate(authentication);
//        if(authentication.getDetails())
        return newAuthentication;
    }
}
