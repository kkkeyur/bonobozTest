package com.example.bonoboz.bootstrap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.bonoboz.DAOServies.RoleDAOService;
import com.example.bonoboz.DAOServies.UserDAOService;
import com.example.bonoboz.domain.Role;
import com.example.bonoboz.domain.User;

@Component
public class JPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	RoleDAOService roleService;

	@Autowired
	UserDAOService userDAOService;

	private void loadRoles() {
		Role role = new Role();
		role.setRole("USER");
		roleService.save(role);
		System.out.println("Saved role" + role.getRole());
		Role adminRole = new Role();
		adminRole.setRole("ADMIN");
		roleService.save(adminRole);
		System.out.println("Saved role" + adminRole.getRole());
	}

	private void loadUsers() {

		User defaultAdmin = new User();
		defaultAdmin.setUsername("admin");
		defaultAdmin.setPassword("password");
		userDAOService.save(defaultAdmin);

		User defaultUser = new User();
		defaultUser.setUsername("user");
		defaultUser.setPassword("password");
		userDAOService.save(defaultUser);

	}

	private void assignUsersToUserRole() {

		List<User> users = (List<User>) userDAOService.listAllUsers();
		List<Role> roles = (List<Role>) roleService.listAllRoles();
		roles.forEach(role -> {
			if (role.getRole().equalsIgnoreCase("USER")) {
				users.forEach(user -> {
					if (user.getUsername().equals("user")) {
						user.addRole(role);
						userDAOService.save(user);
					}
				});
			}
		});
	}

	private void assignUsersToAdminRole() {
		List<Role> roles = (List<Role>) roleService.listAllRoles();
		List<User> users = (List<User>) userDAOService.listAllUsers();
		roles.forEach(role -> {
			if (role.getRole().equalsIgnoreCase("ADMIN")) {
				users.forEach(user -> {
					if (user.getUsername().equals("admin")) {
						user.addRole(role);
						userDAOService.save(user);
					}
				});
			}
		});
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadRoles();
		loadUsers();
		assignUsersToAdminRole();
		assignUsersToUserRole();

	}

}
