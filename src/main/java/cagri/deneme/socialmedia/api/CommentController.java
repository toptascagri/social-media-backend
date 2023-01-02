package cagri.deneme.socialmedia.api;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cagri.deneme.socialmedia.business.abstracts.CommentService;
import cagri.deneme.socialmedia.entities.Comment;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;
	public CommentController(CommentService commentService) {
		this.commentService=commentService;
	}

	@GetMapping("/getComments")
	public List<Comment>getCommentsUserIdOrPostId(@RequestParam Optional<Long>postId, @RequestParam Optional<Long>userId){
	
		return commentService.getAllComments(postId, userId);
		}

	
	@GetMapping("/getOneComment")
	public Comment getOneComment (@RequestParam Long commentId) {
		
		return commentService.getOneCommentById(commentId);
	}
	
	@PostMapping
	public Comment createOneComment(@RequestParam Long id,@RequestParam Long postId,
			@RequestParam String text,@RequestParam Long userId) {
		return commentService.createOneComment(id, postId, text, userId);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOnePost (@PathVariable Long commentId,@RequestParam String text) {
		return commentService.updateOneComment(commentId, text);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteComment(@PathVariable Long commentId) {
		commentService.deleteOneComment(commentId);
	}
	
	@GetMapping("/getAllComments")
	public List<Comment> getAllComments (){
		return commentService.getAllComment();
	}
}


