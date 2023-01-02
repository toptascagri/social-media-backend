package cagri.deneme.socialmedia.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import cagri.deneme.socialmedia.business.abstracts.CommentService;
import cagri.deneme.socialmedia.business.abstracts.PostService;
import cagri.deneme.socialmedia.business.abstracts.UserService;
import cagri.deneme.socialmedia.dataAccess.abstracts.CommentRepository;
import cagri.deneme.socialmedia.entities.Comment;
import cagri.deneme.socialmedia.entities.Post;
import cagri.deneme.socialmedia.entities.User;

@Component
public class CommentManager implements CommentService{
	
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	public CommentManager(CommentRepository commentRepository,UserService userService,PostService postService) {
		super();
		this.commentRepository = commentRepository;
		this.postService=postService;
		this.userService=userService;
	}

	@Override
	public List<Comment> getAllComments(Optional<Long> userId,Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}
		else if (userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
			
		}
		else if (postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		}
		else {
			return commentRepository.findAll();	
		}
		
	}

	@Override
	public Comment getOneCommentById(Long CommentId) {
		return commentRepository.findById(CommentId).orElse(null);
	}

	@Override
	public Comment createOneComment(Long id, Long postId, String text, Long userId) {

		User user=userService.getUserById(userId);
		Post post=postService.getOnePostById(postId);
		
		
		if (user != null && post !=null) {
			Comment toSave=new Comment();
			toSave.setUser(user);
			toSave.setPost(post);
			toSave.setId(id);
			toSave.setText(text);
			commentRepository.save(toSave);
			return toSave;
		}
		else {
			return null;
		}
	
		

	}

	@Override
	public Comment updateOneComment(Long commentId, String text) {
		
		Optional<Comment> comment= commentRepository.findById(commentId);
		if (comment.isPresent()) {
			Comment toUpdate= comment.get();
			toUpdate.setText(text);
			commentRepository.save(toUpdate);
			return toUpdate;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteOneComment(Long id) {
		commentRepository.deleteById(id);
		
	}

	@Override
	public List<Comment> getAllComment() {

		return commentRepository.findAll();
	}

}
