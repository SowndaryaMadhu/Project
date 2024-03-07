package com.app.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.entity.Post;
import com.app.repository.PostRepository;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    public void createPost(@RequestParam String content, @RequestParam User author) {
        //Post newPost = new Post(content, author);
       // postRepository.addPost(newPost);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable int postId) {
        return postRepository.getPostById(postId);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    @PutMapping("/{postId}")
    public void updatePost(@PathVariable int postId, @RequestParam String newContent) {
        Post postToUpdate = postRepository.getPostById(postId);
        if (postToUpdate != null) {
            postToUpdate.setContent(newContent);
            postRepository.updatePost(postToUpdate);
        } else {
            throw new IllegalArgumentException("Post with ID " + postId + " does not exist.");
        }
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable int postId) {
        postRepository.deletePost(postId);
    }
}
