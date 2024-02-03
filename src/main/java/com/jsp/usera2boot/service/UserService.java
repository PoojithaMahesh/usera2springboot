package com.jsp.usera2boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.usera2boot.dao.UserDao;
import com.jsp.usera2boot.dto.User;
import com.jsp.usera2boot.exception.UserIdNotFoundException;
import com.jsp.usera2boot.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User dbUser=dao.findUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
			
		}else {
			throw new UserIdNotFoundException("Failed to fetch the data");
			
		}
		
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User dbUser=dao.deleteUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("data deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
			
		}else {
			throw new UserIdNotFoundException("Failed to Delete the data");
		}
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User dbUser=dao.updateUser(id,user);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("data Updated successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
			
		}else {
			throw new UserIdNotFoundException("Failed to update the data");
		}
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		List<User> list=dao.findAllUser();
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
		structure.setMessage("data fetched successfully");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<User>>> findByName(String name) {
		List<User>  list=dao.findByName(name);
		
		if(list.isEmpty()) {
//			no users found in this name you guys please raise one exception
			return null;
		}else {
			ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
			structure.setMessage("data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
		}
		
	}

}
