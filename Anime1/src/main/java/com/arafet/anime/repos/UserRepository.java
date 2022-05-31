package com.arafet.anime.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arafet.anime.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}