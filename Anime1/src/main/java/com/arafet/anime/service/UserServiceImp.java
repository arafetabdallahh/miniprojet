package com.arafet.anime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.arafet.anime.entities.User;
import com.arafet.anime.repos.RoleRepository;
import com.arafet.anime.repos.UserRepository;

public class UserServiceImp implements UserService{
	
	@Autowired
	UserRepository userRepo;
	@Autowired
    RoleRepository roleRepo;
	@Override

	public User saveUser(User u) {
		
		
		return userRepo.save(u);
	}

	@Override
	public User updateUser(User u) {
		PasswordEncoder passwordEncoder = passEncoder ();
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		u.setEnabled(true);
		
		return userRepo.save(u);
	}

	@Override
	public void deleteUser(User u) {
	
	userRepo.delete(u);
		
	}

	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
		
	}

	@Override
	public User getUser(Long id) {
		
		return userRepo.getById(id);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public Page<User> getAllUsersParPage(int page, int size) {
		
		return userRepo.findAll(PageRequest.of(page, size));
	}

	
	 @Bean
	 public PasswordEncoder passEncoder () {
	 return new BCryptPasswordEncoder();
	 }

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
