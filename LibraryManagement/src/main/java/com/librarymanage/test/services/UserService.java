package com.librarymanage.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanage.test.entities.User;
import com.librarymanage.test.repositiory.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() //Find all User
	{
		return userRepository.findAll();
	}

	public User save(User user) //Add User
	{
		return userRepository.save(user);
	}

	public void deleteById(int id)	//Delete the User by userId
	{
		userRepository.deleteById(id);
	}
	
	public Optional<User> userById(int id,User user)
	{
		return userRepository.findById(id);
	}
}
