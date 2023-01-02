package cagri.deneme.socialmedia.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cagri.deneme.socialmedia.business.abstracts.PostService;
import cagri.deneme.socialmedia.entities.Post;
import cagri.deneme.socialmedia.reponses.PostResponse;
import cagri.deneme.socialmedia.requests.PostCreateRequest;

@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PostController {

	private PostService postService;
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPost(userId);
	}
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest ) {
		return postService.createOnePost(newPostRequest);
	}
	
	@RequestMapping(path="/delete", method = RequestMethod.POST)
	public void deleteOnePost(@RequestParam Long postId) {
		postService.deletePost(postId);
	}
	
	@RequestMapping(path="/update", method = RequestMethod.POST)
	public Post updateOnePost(@RequestParam Long postId,String text,String title) {
		return postService.updatePost(postId, text, title);
	}
	
}
