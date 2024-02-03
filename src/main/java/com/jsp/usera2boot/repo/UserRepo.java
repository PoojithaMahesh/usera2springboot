package com.jsp.usera2boot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.usera2boot.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("Select u from User u where u.name=?1")
	Optional<List<User>> findByName(String name);

}
