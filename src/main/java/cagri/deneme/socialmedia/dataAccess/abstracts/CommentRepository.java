package cagri.deneme.socialmedia.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cagri.deneme.socialmedia.entities.Comment;

@Component
public interface CommentRepository extends JpaRepository<Comment,Long> {

	List<Comment>findByUserIdAndPostId(Long userId,Long postId);

	List<Comment> findByUserId(Long postId);
	
	List<Comment> findByPostId(Long userId);
	
	
	
}
