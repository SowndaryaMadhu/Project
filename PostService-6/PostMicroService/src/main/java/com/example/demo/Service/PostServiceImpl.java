
package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


import com.example.demo.Model.Post;
import com.example.demo.Model.User;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;



@Service

public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository repo;
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Post> getAllPosts() {
	    return repo.findAll();
	}
	
	@Override
	public Optional<Post> getPostById(int id) {
	    return repo.findById(id);
	}
	@Override
	public Post createPost(Post post) {
	    return repo.save(post);
	}
	
	
	
	
	
	@Override
	public void deletePost(int id) {
	    repo.deleteById(id);
	}

	@Override
	public Post createNewPost(Post post, Integer userId) throws Exception {
		
		User user = userService.findUserById(userId);
		
		 Post newPost = new Post();
		 newPost.setContent(post.getContent());
		 newPost.setShares(post.getShares());
		 newPost.setLikes(post.getLikes());
		 newPost.setComments(post.getComments());
		 newPost.setImageUrl(post.getImageUrl());
		 newPost.setVideo(post.getVideo());
		 
		 newPost.setUser(user);
		 
		 
		 return repo.save(newPost);
	}

	@Override
	public List<Post> findPostByUserId(Integer userId) {
		
		return repo.findPostByUserId(userId);
	}

//
//	@Override
//	public Post updatePost(int id, Post updatedPost) {
//	    
//	    Optional<Post> optionalPost = repo.findById(id);
//	    if (!optionalPost.isPresent()) {
//	      
//	        throw new IllegalArgumentException("Post with ID " + id + " not found");
//	    }
//
//	    
//	    Post existingPost = optionalPost.get();
//
//	    
//	    existingPost.setContent(updatedPost.getContent());
//	    existingPost.setShares(updatedPost.getShares());
//	    existingPost.setLikes(updatedPost.getLikes());
//	    existingPost.setImageUrl(updatedPost.getImageUrl());
//	    existingPost.setVideo(updatedPost.getVideo());
//	    
//	    if (updatedPost.getUser() != null) {
//	        existingPost.setUser(updatedPost.getUser());
//	    }
//
//	    
//	    return repo.save(existingPost);
//	}
	
	@Override
     public Post updatePost(int id, Post updatedPost) {

	Optional<Post> existingPostOptional = repo.findById(id);
    if (existingPostOptional.isPresent()) {

     Post existingPost = existingPostOptional.get();
	 
		         if (updatedPost.getContent() != null) {
                     existingPost.setContent(updatedPost.getContent());
                     }

		       
		        if (updatedPost.getShares() != null) {

		            existingPost.setShares(updatedPost.getShares());

		        }

		        if (updatedPost.getLikes() != null) {

		            existingPost.setLikes(updatedPost.getLikes());
                    }
		        return repo.save(existingPost);

		    } else {

		        return null;
		    }

		}



	
	
	
}	

	


	

	

	

	
	


	
	


