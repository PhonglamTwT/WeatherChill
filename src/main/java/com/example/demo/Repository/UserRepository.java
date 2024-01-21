package com.example.demo.Repository;

import com.example.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmailAndPassword(String email, String password);

    UserEntity findByEmail(String email);

    UserEntity findByName(String name);

}
