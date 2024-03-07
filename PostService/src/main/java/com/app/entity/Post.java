package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId; 
	
	
	private String content;    
	private int likes;    
	private int shares;
	
	
	
	public Post(int postId, String content, int likes, int shares) {
		super();
		this.postId = postId;
		this.content = content;
		this.likes = likes;
		this.shares = shares;
	}
	
	
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", content=" + content + ", likes=" + likes + ", shares=" + shares + "]";
	}
	    
	
	
	
	
}
