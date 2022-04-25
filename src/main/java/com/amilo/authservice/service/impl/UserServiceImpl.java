package com.amilo.authservice.service.impl;

import com.amilo.authservice.dto.UserPrincipal;
import com.amilo.authservice.repository.UserRepository;
import com.amilo.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserPrincipal(userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)));
    }
}
