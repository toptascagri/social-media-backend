package cagri.deneme.socialmedia.reponses;

import cagri.deneme.socialmedia.entities.Post;
import lombok.Data;

@Data
public class PostResponse { 
	Long id;
	Long userId;
	String userName;
	String title;
	String text;
	
	public PostResponse(Post entity) {
		this.id=entity.getId();
		this.userId=entity.getUser().getId();
		this.title=entity.getText();
		this.userName=entity.getUser().getUserName();
		this.text=entity.getText();
	}

}
