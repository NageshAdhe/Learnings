package com.igat.SpringSecureEx.service;

import com.igat.SpringSecureEx.models.UserPrincipal;
import com.igat.SpringSecureEx.models.Users;
import com.igat.SpringSecureEx.respos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("USER NOT FOOUND");
        }
        return new UserPrincipal(user);
    }
}
