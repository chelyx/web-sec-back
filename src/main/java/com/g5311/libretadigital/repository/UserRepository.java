package com.g5311.libretadigital.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5311.libretadigital.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>, CustomUserRepository {

    List<User> findByRol(String rol);

    User findByEmail(String email);

}
