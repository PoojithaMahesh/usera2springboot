package com.jsp.usera2boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.usera2boot.dao.UserDao;
import com.jsp.usera2boot.dto.User;
import com.jsp.usera2boot.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseStructure<User> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		
		return structure;
		
	}

	public ResponseStructure<User> findUser(int id) {
		User dbUser=dao.findUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return structure;
			
		}else {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Sorry Id is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return structure;
		}
		
	}

	public ResponseStructure<User> deleteUser(int id) {
		User dbUser=dao.deleteUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("data deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return structure;
			
		}else {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Sorry Id is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return structure;
		}
	}

	public ResponseStructure<User> updateUser(int id, User user) {
		User dbUser=dao.updateUser(id,user);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("data Updated successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return structure;
			
		}else {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Sorry Id is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return structure;
		}
	}

}
