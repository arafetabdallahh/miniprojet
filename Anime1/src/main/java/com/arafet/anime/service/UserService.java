package com.arafet.anime.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.arafet.anime.entities.User;
@Service
public interface UserService {

	 List <User> findAll();
	    
	    User saveUser(User u);
	    User updateUser(User u);
	    void deleteUser(User u);
	     void deleteUserById(Long id);
	     User getUser(Long idUser);
	     List<User> getAllUsers();
		    Page<User> getAllUsersParPage(int page, int size);
}
