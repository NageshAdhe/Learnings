package com.igat.SpringSecureEx.respos;

import com.igat.SpringSecureEx.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
