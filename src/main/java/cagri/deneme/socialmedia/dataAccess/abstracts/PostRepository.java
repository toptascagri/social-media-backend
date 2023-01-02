package cagri.deneme.socialmedia.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cagri.deneme.socialmedia.entities.Post;

@Component
public interface PostRepository extends JpaRepository<Post,Long> {
	
	List<Post>findByUserId(Optional<Long> userId);
	Post getPostById(Long postId);

}
