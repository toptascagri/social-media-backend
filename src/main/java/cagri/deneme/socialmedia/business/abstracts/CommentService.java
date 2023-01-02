package cagri.deneme.socialmedia.business.abstracts;

import java.util.List;
import java.util.Optional;

import cagri.deneme.socialmedia.entities.Comment;

public interface CommentService  {

	List<Comment> getAllComments(Optional<Long> userId,Optional<Long> postId);
	
	Comment getOneCommentById(Long CommentId);
	
	Comment createOneComment(Long id,Long postId,String text,Long userId);
	
	Comment updateOneComment (Long commentId,String text);
	
	void deleteOneComment(Long id);
	
	List<Comment> getAllComment();
	
}
