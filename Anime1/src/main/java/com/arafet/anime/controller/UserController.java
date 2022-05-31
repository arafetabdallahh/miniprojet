package com.arafet.anime.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arafet.anime.entities.Role;
import com.arafet.anime.entities.User;
import com.arafet.anime.service.RoleService;
import com.arafet.anime.service.UserService;
import com.arafet.anime.security.SecurityConfig;

@Controller
public class UserController {

	@Autowired
    UserService   userService;
	@Autowired
	RoleService roleService;
	 @RequestMapping("/ListeUsers")
	    public String finduser(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {      
	    	
	    	 Page <User> users = userService.getAllUsersParPage(page, size);
		     modelMap.addAttribute("user", users);
		     modelMap.addAttribute("pages", new int[users.getTotalPages()]);
		     modelMap.addAttribute("currentPage", page);
		    return "listeUsers";
	    	
	    }
	 
	  @RequestMapping("/CreateUser")
	  public String createUser(ModelMap modelMap)
	    {
		  
	  
	    List<Role> roles = roleService.getAllRoles();
	    modelMap.addAttribute("user", new User());
	    modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("roles",roles);
	    return "formUser";
	    }
	  
	  @RequestMapping("/saveUser")
	    public String saveUser(@Valid User user ,int role,BindingResult bindingResult)
	    {
	    if (bindingResult.hasErrors()) return "formUser";
	    SecurityConfig sc = new SecurityConfig();
	    PasswordEncoder passwordEncoder = sc.passwordEncoder ();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
	    List<Role> All= roleService.findAll();   
     	Role r1=All.get(role -1);
     	List<Role> listR = new ArrayList<Role>();
     	listR.add(r1);
     	user.setRoles(listR);
     	List<Role> list=user.getRoles();
	    userService.saveUser(user);
		return "redirect:/ListeUsers";
	    }
	  
	
	  @RequestMapping("/modifierUser")
	    public String editerUser(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    User p= userService.getUser(id);
	    modelMap.addAttribute("user", p);
	    modelMap.addAttribute("mode", "edit");
	    List<Role> roles = roleService.getAllRoles();
		modelMap.addAttribute("roles",roles);
	    return "formUser";
	    }

	    
	    @RequestMapping("/updateUser")
	    public String updateUser(@ModelAttribute("user") User user, int role,
	                                ModelMap modelMap) throws ParseException
	    {
	    	
	    	List<Role> All= roleService.findAll();   
	     	Role r1=All.get(role -1);
	     	List<Role> listR = new ArrayList<Role>();
	     	listR.add(r1);
	     	user.setRoles(listR);
	     	List<Role> list=user.getRoles();
	        userService.updateUser(user);
	        List<User> users = userService.getAllUsers();
	        modelMap.addAttribute("users",users);
	        return "listeUsers";
	    }
	    
	    @RequestMapping("/supprimerUser")
		public String supprimerUser(@RequestParam("id") Long id, ModelMap modelMap,

			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

			User user =userService.getUser(id);
			user.setRoles(null);
			userService.updateUser(user);
			userService.deleteUserById(id);
			Page<User> use = userService.getAllUsersParPage(page,
					size);
			modelMap.addAttribute("users", use);
			modelMap.addAttribute("pages", new int[use.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "redirect:/ListeUsers";
		}
}
