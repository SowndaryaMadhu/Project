
package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.PostNotFoundException;
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
	
	
	
//	@Override
//	public Post updatePost(int id, Post updatedPost) {
//	    updatedPost.setId(id);
//	    return repo.save(updatedPost);
//	}
	
//	@Override
//	public Post updatePost(int id, Post updatedPost) {
//	    Optional<Post> existingPostOptional = repo.findById(id);
//	    if (existingPostOptional.isPresent()) {
//	        Post existingPost = existingPostOptional.get();
//	        existingPost.setContent(updatedPost.getContent());
//	        existingPost.setShares(updatedPost.getShares());
//	        existingPost.setLikes(updatedPost.getLikes());
//	        existingPost.setComments(updatedPost.getComments());
//	        existingPost.setImageUrl(updatedPost.getImageUrl());
//	        existingPost.setVideo(updatedPost.getVideo());
//	        // No need to update user as it's not supposed to be modified here
//
//	        return repo.save(existingPost);
//	    } else {
//	        return null; // Indicate that the post with given id doesn't exist
//	    }
//	}

	@Override
	public Post updatePost(int id, Post updatedPost) {
	    Optional<Post> existingPostOptional = repo.findById(id);
	    if (existingPostOptional.isPresent()) {
	        Post existingPost = existingPostOptional.get();

	        // Check if the updatedPost has content, update it if present
	        if (updatedPost.getContent() != null) {
	            existingPost.setContent(updatedPost.getContent());
	        }
	        // Similarly, check and update other fields if they are not null in updatedPost
	        if (updatedPost.getShares() != null) {
	            existingPost.setShares(updatedPost.getShares());
	        }
	        if (updatedPost.getLikes() != null) {
	            existingPost.setLikes(updatedPost.getLikes());
	        }
	        // Update other fields in a similar manner

	        return repo.save(existingPost);
	    } else {
	        return null; // Indicate that the post with the given id doesn't exist
	    }
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

	
	
	
	
	
	@Override
	public byte[] getImageBytes(int postId) {
	    Optional<Post> postOptional = repo.findById(postId);
	    if (postOptional.isPresent()) {
	        Post post = postOptional.get();
	        return post.getImageBytes();
	    } else {
	        throw new PostNotFoundException("Post not found with id: " + postId);
	    }
	}
 
	@Override
	public void updateImageBytes(int postId, byte[] imageBytes) {
	    Optional<Post> postOptional = repo.findById(postId);
	    if (postOptional.isPresent()) {
	        Post post = postOptional.get();
	        post.setImageBytes(imageBytes);
	        repo.save(post);
	    } else {
	        throw new PostNotFoundException("Post not found with id: " + postId);
	    }
	}
	
	@Override
	public void updateImageBytes1(int postId, byte[] imageBytes) {
	    Optional<Post> postOptional = repo.findById(postId);
	    if (postOptional.isPresent()) {
	        Post post = postOptional.get();
	        post.setImageBytes(imageBytes);
	        repo.save(post);
	    } else {
	        throw new PostNotFoundException("Post not found with id: " + postId);
	    }
	}



	
	
		
//		
//	@Override
//	public Post createNewPost(Post post, Integer userId, MultipartFile image) throws Exception {
//	    User user = userService.findUserById(userId);
//	    
//	    Post newPost = new Post();
//	    // Set other post details
//	    newPost.setContent(post.getContent());
//	    newPost.setShares(post.getShares());
//	    newPost.setLikes(post.getLikes());
//	   // newPost.setComments(post.getComments());
//	    newPost.setVideo(post.getVideo());
//	    newPost.setUser(user);
//	    
//	    // Set image data
//	    newPost.setImageBytes(image.getBytes());
//	    
//	    return repo.save(newPost);
//	}

	
	
}

