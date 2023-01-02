package cagri.deneme.socialmedia.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cagri.deneme.socialmedia.entities.User;

@Component
public interface UserRepository extends JpaRepository<User,Long> {

	
}
