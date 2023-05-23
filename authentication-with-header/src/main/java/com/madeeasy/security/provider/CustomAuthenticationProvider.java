package com.madeeasy.security.provider;

import com.madeeasy.security.token.CustomAuthenticationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthenticationToken token = (CustomAuthenticationToken) authentication;
        String tokenKey = (String) token.getKey();
        if (key.equals(tokenKey)) {
            return new CustomAuthenticationToken(true, null);
        }
        throw new BadCredentialsException("Invalid key");
//		 return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(CustomAuthenticationToken.class);
    }

}
