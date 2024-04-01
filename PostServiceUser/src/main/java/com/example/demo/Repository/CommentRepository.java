package com.example.demo.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Comment;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Integer>{

	List<Comment> findByUserEmailAndPostId(String email, int postId);

	List<Comment> findByUserEmailAndPostDate(String email, LocalDateTime date);


	

}
