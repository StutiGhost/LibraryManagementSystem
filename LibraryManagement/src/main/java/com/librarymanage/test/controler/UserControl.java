package com.librarymanage.test.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.librarymanage.test.entities.User;
import com.librarymanage.test.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserControl {
	@Autowired
	private UserService userService;

	//Retrieve User Data
	@GetMapping()
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	//Add User
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.save(user);
	}
	//Get user details by userId
	@GetMapping("/{id}/")
	public Optional<User> getUsersbyId(@PathVariable int id, @RequestBody User user) {
		return userService.userById(id, user);
	}
	//Update User
	@PutMapping("/{id}/")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		// Additional logic to ensure you're updating the correct book
		return userService.save(user);
	}
	
	//Delete User
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable int id) {
		userService.deleteById(id);
	}
	
}
