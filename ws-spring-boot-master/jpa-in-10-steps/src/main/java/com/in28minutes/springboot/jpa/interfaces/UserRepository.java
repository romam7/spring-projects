package com.in28minutes.springboot.jpa.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
