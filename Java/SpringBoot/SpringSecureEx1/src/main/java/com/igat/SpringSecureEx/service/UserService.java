package com.igat.SpringSecureEx.service;

import com.igat.SpringSecureEx.models.Users;
import com.igat.SpringSecureEx.respos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;
    public Users register(Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verifyUser(Users user) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return "FAIL";
    }
}
