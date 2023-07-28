package com.example.auth.security.jwt;

import com.example.auth.entity.User;
import com.example.auth.security.service.UserDetailsImpl;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionHelper {
    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return ((UserDetailsImpl)authentication.getPrincipal()).getUser();
        }
        return null;
    }
}
