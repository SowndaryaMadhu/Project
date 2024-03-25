
package com.example.demo.Service;

import java.util.List;
import java.util.Optional;



import com.example.demo.Model.Post;


public interface PostService {
 List<Post> getAllPosts();
 List<Post> getPostsByUserEmail(String email);
 Post createNewPost(Post post, String email) throws Exception;
  Optional<Post> getPostById(int id);
  Post updatePost(int id, Post updatedPost, String email) throws Exception;
  void deletePost(int id, String email) throws Exception;
//    Post createPost(Post post);
//    Post updatePost(int id, Post updatedPost);
//    void deletePost(int id);
//   Post createNewPost(Post post,Integer userId)throws Exception;
//   
//    List<Post>findPostByUserId(Integer userId);
//    //Post createNewPost(Post post, Integer userId, MultipartFile image) throws Exception;
//   
    byte[] getImageBytes(int postId);
    void updateImageBytes(int postId, byte[] imageBytes);
	void updateImageBytes1(int postId, byte[] imageBytes);


    
}
