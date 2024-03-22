package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostDTO;
import com.example.demo.mapper.PostMapper;
import com.example.demo.Model.Post;
import com.example.demo.Service.PostService;

@RestController
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping("/details")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<Post> posts = service.getAllPosts();
        List<PostDTO> postDTOs = posts.stream().map(PostMapper::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(postDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable int id) {
        Optional<Post> post = service.getPostById(id);
        if (post.isPresent()) {
            PostDTO postDTO = PostMapper.toDTO(post.get());
            return new ResponseEntity<>(postDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post updatedPost, @PathVariable int id) {
        try {
           Post post = service.updatePost(id, updatedPost);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }	
   
//    @PutMapping("/{id}")
//    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO updatedPostDTO, @PathVariable int id) {
//        try {
//            Post updatedPost = service.updatePost(id, PostMapper.toEntity(updatedPostDTO));
//            if (updatedPost != null) {
//                PostDTO responseDTO = PostMapper.toDTO(updatedPost);
//                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        try {
            service.deletePost(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<List<PostDTO>> findUsersPost(@PathVariable Integer userId) {
        List<Post> posts = service.findPostByUserId(userId);
        List<PostDTO> postDTOs = posts.stream().map(PostMapper::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(postDTOs, HttpStatus.OK);
    }
   

    @PostMapping("/posts/user/{userId}")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId) throws Exception {
        Post post = PostMapper.toEntity(postDTO);
        Post createdPost = service.createNewPost(post, userId);
        PostDTO createdPostDTO = PostMapper.toDTO(createdPost);
        return new ResponseEntity<>(createdPostDTO, HttpStatus.ACCEPTED);
    }

}
