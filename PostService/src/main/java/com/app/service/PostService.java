package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Post;
import com.app.repository.PostRepository;

@Service
public class PostService {
	  private final PostRepository postRepository;

	    @Autowired
	    public PostService(PostRepository postRepository) {
	        this.postRepository = postRepository;
	    }

	    public void createPost(Post post) {
	        postRepository.addPost(post);
	    }

	    public Post getPostById(int postId) {
	        return postRepository.getPostById(postId);
	    }

	    public List<Post> getAllPosts() {
	        return postRepository.getAllPosts();
	    }

	    public void updatePost(Post updatedPost) {
	        postRepository.updatePost(updatedPost);
	    }

	    public void deletePost(int postId) {
	        postRepository.deletePost(postId);
	    }

}
