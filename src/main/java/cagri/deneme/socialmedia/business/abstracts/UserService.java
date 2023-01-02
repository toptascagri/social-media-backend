package cagri.deneme.socialmedia.business.abstracts;

import java.util.List;
import cagri.deneme.socialmedia.entities.User;

public interface UserService {

	User add(User user);
	void delete(Long id);
	User getUser(Long id,User newUser);
	User getUserById(Long id);
	List<User>getAllUsers();
	

	
}
