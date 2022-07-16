package com.amilo.authservice.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Code {


    private final PasswordEncoder passwordEncoder;

    public Code(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void test() {
        System.out.println(passwordEncoder.encode("123456"));
    }
}
