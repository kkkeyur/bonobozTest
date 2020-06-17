package com.example.bonoboz.DAOServies;

import java.util.List;
import java.util.Optional;

import com.example.bonoboz.domain.User;

public interface UserDAOService {

	List<User> listAllUsers();

	Optional<User> getUserByID(Integer id);

	User save(User user);

	User Update(Integer Id,User user);

	void deleteUser(Integer id);
	
    User findByUsername(String username);


}
