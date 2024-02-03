package com.jsp.usera2boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.usera2boot.dto.User;
import com.jsp.usera2boot.repo.UserRepo;

import jakarta.persistence.EntityManagerFactory;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
	return repo.save(user);
		
	}

	public User findUser(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			id is present
			User user=optional.get();
			return user;
		}else {
//			id is not present
			return null;
		}
	}

	public User deleteUser(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			id is present 
			User user=optional.get();
			repo.delete(user);
			return user;
		}
		return null;
		
	}

	public User updateUser(int id, User user) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			id is presnet then i can update the data
			user.setId(id);
			 return repo.save(user);
		}
		return null;
	}

	public List<User> findAllUser() {
		return repo.findAll();
	}

	public List<User> findByName(String name) {
	Optional<List<User>> optional=repo.findByName(name);
	if(optional.isPresent()) {
		return optional.get();
	}
	return null;
	}

	
	
	
}
