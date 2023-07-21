package com.example.auth.service.impl;

import com.example.auth.entity.User;
import com.example.auth.repository.UserRepository;
import com.example.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired(required = false)
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Integer saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); //encode before saving to Database
        return userRepository.save(user).getId();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepository.findByUsername(username);
        org.springframework.security.core.userdetails.User springUser=null;

        if (opt.isEmpty()) {
            throw new UsernameNotFoundException("Not found");
        } else {
            User user = opt.get(); //retrieving user from DB
            Set<String> roles = user.getRoles();
            Set<GrantedAuthority> ga = new HashSet<>();
            for (String role:roles) {
                ga.add(new SimpleGrantedAuthority(role));
            }
            springUser = new org.springframework.security.core.userdetails.User(
                    username,
                    user.getPassword(),
                    ga
            );
        }
        return springUser;
    }
}
