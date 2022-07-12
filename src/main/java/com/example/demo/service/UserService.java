package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository usRepo;
	
	public void save(User user) {
		usRepo.save(user);
	}
	
	public User findById(int id) {
		User user = usRepo.findById(id).get();
		return user;
	}
	
	public List<User> findAll(){
		return (List<User>) usRepo.findAll();
	}
	
//	public boolean isSamePassword(String firstPass, String secondPass) {
//		return firstPass.equals(secondPass)? true:false;
//	}
}
