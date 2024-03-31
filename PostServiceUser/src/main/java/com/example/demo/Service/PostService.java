
package com.example.demo.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.Exception.PostNotFoundException;

import com.example.demo.Model.Post;


public interface PostService {
 List<Post> getAllPosts();
 List<Post> getPostsByUserEmail(String email);
 
  Optional<Post> getPostById(int id);
  Post updatePost(int id, Post updatedPost, String email) throws Exception;
  void deletePostsByEmail(String email) throws PostNotFoundException;
  void deletePostsByEmailAndDate(String email, Date date) throws PostNotFoundException;
  void deletePostsByEmailAndDate(String email, LocalDateTime date);
  
  
  
  
  
  Post updatePostByEmail(Post updatedPost, String email) throws Exception;

  
  
  Post updatePost(Post updatedPost, String email) throws Exception;

   

  
 
  void updateImageBytes(String email, int postId, byte[] imageBytes);

 
  Post savePost(Post post);

  
  Post createNewPost(Post post, String email, LocalDateTime currentDateTime) throws Exception;

  Optional<List<Post>> getPostsByEmailAndDate(String email, LocalDateTime date);
  void likePostByEmailAndDate(String email, LocalDateTime date);
  void sharePostByEmailAndDate(String email, LocalDateTime date);

void deletePostsByDate(LocalDateTime dateTime);
void updatePostsByEmailAndDate(String email, LocalDateTime dateTime, Post updatedPost);






	

	
	
	
    
}
