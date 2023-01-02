package cagri.deneme.socialmedia.api;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cagri.deneme.socialmedia.business.abstracts.UserService;
import cagri.deneme.socialmedia.entities.User;


@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	private UserService userService;
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.add(user);
	}

	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser) {
		return userService.getUser(userId, newUser);
		
	}
	
	@DeleteMapping("{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.delete(userId);
	}
	
	
	
	
}
