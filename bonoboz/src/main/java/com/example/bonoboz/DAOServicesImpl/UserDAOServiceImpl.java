package com.example.bonoboz.DAOServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bonoboz.DAOServies.UserDAOService;
import com.example.bonoboz.domain.User;
import com.example.bonoboz.repo.UserRepo;

@Service
public class UserDAOServiceImpl implements UserDAOService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	UserRepo userRepo;

	@Override
	public List<User> listAllUsers() {
		List<User> userList = userRepo.findAll();
		return userList;

	}

	@Override
	public Optional<User> getUserByID(Integer id) {
		Optional<User> u = userRepo.findById(id);
		return u;
	}

	@Override
	public User save(User user) {
		if (user.getPassword() != null) {
			user.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
		}
		userRepo.save(user);
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		// User deleted = userRepo.getOne(id);
		userRepo.deleteById(id);
		return;

	}

	@Override
	public User Update(Integer id, User user) {
		User saved = userRepo.getOne(id);

		saved.setUsername(user.getUsername());
		saved.setPassword(user.getPassword());
		saved.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
		return saved;

	}

	@Override
	public User findByUsername(String username) {
		User found = userRepo.findByUsername(username);
		return found;
	}

}
