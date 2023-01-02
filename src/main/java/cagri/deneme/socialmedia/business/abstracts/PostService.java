package cagri.deneme.socialmedia.business.abstracts;

import java.util.List;
import java.util.Optional;

import cagri.deneme.socialmedia.entities.Post;
import cagri.deneme.socialmedia.reponses.PostResponse;
import cagri.deneme.socialmedia.requests.PostCreateRequest;

public interface PostService {
	
	List<PostResponse> getAllPost(Optional<Long> userId);
	Post getOnePostById(Long PostId);
	Post createOnePost(PostCreateRequest newPostRequest);
	void deletePost(Long postId);
	Post updatePost(Long postId,String newText,String newTitle);
}
