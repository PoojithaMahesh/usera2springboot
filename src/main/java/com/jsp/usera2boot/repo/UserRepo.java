package com.jsp.usera2boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.usera2boot.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
