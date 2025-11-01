package com.g5311.libretadigital.repository;

import java.util.List;
import java.util.Map;

import com.g5311.libretadigital.model.User;

public interface CustomUserRepository {
    List<User> findByUsernameVulnerable(String username);
}
