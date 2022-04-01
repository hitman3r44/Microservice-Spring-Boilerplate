package com.wolverine.solutions.accountservice.service.impl;

import com.wolverine.solutions.accountservice.dao.User;
import com.wolverine.solutions.accountservice.repository.UserRepository;
import com.wolverine.solutions.accountservice.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AppUserDetailsServiceImpl implements AppUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository
                .findByUserNameOrEmail(userNameOrEmail, userNameOrEmail);

        User user = userOptional.orElseThrow(() ->
                new UsernameNotFoundException(String.format("The username or email Id %s doesn't exist",
                        userNameOrEmail))
        );

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUserName(), user.getPassword(), authorities);

        return userDetails;
    }
}
