package cagri.deneme.socialmedia.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cagri.deneme.socialmedia.business.abstracts.PostService;
import cagri.deneme.socialmedia.business.abstracts.UserService;
import cagri.deneme.socialmedia.dataAccess.abstracts.PostRepository;
import cagri.deneme.socialmedia.entities.Post;
import cagri.deneme.socialmedia.entities.User;
import cagri.deneme.socialmedia.reponses.PostResponse;
import cagri.deneme.socialmedia.requests.PostCreateRequest;

@Component
public class PostManager implements PostService {

	private PostRepository postRepository;
	private UserService userService;
	
	public PostManager(PostRepository postRepository,UserService userService) {
		super();
		this.postRepository = postRepository;
		this.userService=userService;
	}

	@Override
	public List<PostResponse> getAllPost(Optional<Long> userId) {
		List<Post>list;
		// TODO Auto-generated method stub
		if (userId.isPresent()) {
			
			list=postRepository.findByUserId(userId);
		}
		else {
			list= postRepository.findAll();
			System.out.println(list);
			
		}
		return list.stream().map(p ->new PostResponse(p)).collect(Collectors.toList());
	}

	@Override
	public Post getOnePostById(Long PostId) {
		// TODO Auto-generated method stub
		return postRepository.findById(PostId).orElse(null);
	}

	@Override
	public Post createOnePost(PostCreateRequest newPostRequest) {
		// TODO Auto-generated method stub
		User user=userService.getUserById(newPostRequest.getUserId());
		if (user==null) {
			return null;
		}
		Post tosave =new Post();
		tosave.setId(newPostRequest.getId());
		tosave.setText(newPostRequest.getText());
		tosave.setTile(newPostRequest.getTitle());
		tosave.setUser(user);
		return postRepository.save(tosave);
	}

	@Override
	public void deletePost(Long postId) {
		postRepository.deleteById(postId);
		
	}

	@Override
	public Post updatePost(Long postId, String newText, String newTitle) {
		Post toSave =postRepository.getById(postId);
		toSave.setText(newText);
		toSave.setTile(newTitle);
		postRepository.save(toSave);
		return toSave;
	}

}
