package cagri.deneme.socialmedia.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cagri.deneme.socialmedia.business.abstracts.UserService;
import cagri.deneme.socialmedia.dataAccess.abstracts.UserRepository;
import cagri.deneme.socialmedia.entities.User;

@Component
public class UserManager implements UserService{

	
	private UserRepository userRepository;
	public UserManager(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@Override
	public User add(User user) {

		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public User getUser(Long id, User newUser) {
		Optional <User> user=userRepository.findById(id);
		if (user.isPresent()) {
			User foundUser=user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else
		return null;
	}
	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}
	

}
