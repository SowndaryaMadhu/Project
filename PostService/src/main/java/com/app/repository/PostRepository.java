package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
	void addPost(Post post);
    Post getPostById(int postId);
    List<Post> getAllPosts();
    void updatePost(Post updatedPost);
    void deletePost(int postId);

}
