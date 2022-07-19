package com.ngs.authorization.config;

import com.common.authservice.config.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("deprecation")
@Configuration
@RequiredArgsConstructor
public class CustomTokenConfig {
    private final

    AuthProperties authProperties;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

//    private final RedisConnectionFactory redisConnectionFactory;

    //    @Bean
//    @Primary
//    public TokenStore customTokenStore() {
//        return new RedisTokenStore(redisConnectionFactory);
//    }
    @Bean
    @Primary
    public DaoAuthenticationProvider customDaoAuthenticationProvider() {
        CustomAuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();
        authenticationProvider.setUserDetailsService(this.userDetailsService);
        authenticationProvider.setPasswordEncoder(this.passwordEncoder);
        return authenticationProvider;
    }

    @Bean
    @Primary
    public TokenEnhancer customTokenEnhancer() {
        return (oAuth2AccessToken, oAuth2Authentication) -> {
            DefaultOAuth2AccessToken accessToken = new DefaultOAuth2AccessToken(oAuth2AccessToken);
            Map<String, Object> map = new HashMap<>();
            map.put("refresh_expires_in", authProperties.getRefreshTokenValiditySeconds());
            accessToken.setAdditionalInformation(map);
            return accessToken;
        };
    }

}
