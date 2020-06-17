package com.example.bonoboz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bonoboz.DAOServies.UserDAOService;
import com.example.bonoboz.domain.User;

@RequestMapping("/userapi")
@RestController
public class UserController {

	@Autowired
	UserDAOService userDAOService;

	@GetMapping("/users")
	public List<User> GetList() {

		return userDAOService.listAllUsers();
	}

	@GetMapping("/user/{id}")
	public Optional<User> GetUserId(@PathVariable Integer id) {
		return userDAOService.getUserByID(id);
	}

	@PostMapping("/new")
	public User newUser(@RequestBody User user) {
		return userDAOService.save(user);

	}

	@PutMapping("/update/{id}")
	public User UpdeteUser(@PathVariable Integer id, @RequestBody User user) {
		return userDAOService.Update(id, user);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {

		userDAOService.deleteUser(id);

		return "User deleted";
	}

}
