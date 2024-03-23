package com.example.demo.Model;





import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "post")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
 
    private Integer shares;
    private Integer likes;
//    @Lob
    private byte[] imageBytes;
    public byte[] getImageBytes() {
		return imageBytes;
	}
 
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
 
	private String imageUrl;
    private String video;
    @ManyToOne
	private User user;
    @OneToMany(mappedBy = "post")
    
    private List<Comment> comments = new ArrayList<>();
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getContent() {
		return content;
	}
 
	public void setContent(String content) {
		this.content = content;
	}
 
	
 
	public Integer getShares() {
		return shares;
	}
 
	public void setShares(Integer shares) {
		this.shares = shares;
	}
 
	public Integer getLikes() {
		return likes;
	}
 
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
 
	public String getImageUrl() {
		return imageUrl;
	}
 
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
 
	public String getVideo() {
		return video;
	}
 
	public void setVideo(String video) {
		this.video = video;
	}
 
	public User getUser() {
		return user;
	}
 
	public void setUser(User user) {
		this.user = user;
	}
 
	public List<Comment> getComments() {
		return comments;
	}
 
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
 
	
 
	public Post(int id, String content, Integer shares, Integer likes, byte[] imageBytes, String imageUrl, String video,
			User user, List<Comment> comments) {
		super();
		this.id = id;
		this.content = content;
		this.shares = shares;
		this.likes = likes;
		this.imageBytes = imageBytes;
		this.imageUrl = imageUrl;
		this.video = video;
		this.user = user;
		this.comments = comments;
	}
 
 
	public Post() {
		// TODO Auto-generated constructor stub
	}
 
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", shares=" + shares + ", likes=" + likes + ", imageBytes="
				+ Arrays.toString(imageBytes) + ", imageUrl=" + imageUrl + ", video=" + video + ", user=" + user
				+ ", comments=" + comments + "]";
	}
 
	
 
	

 
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//    
//	private String content;
//
//    private Integer shares;
//    private Integer likes;
////    @Lob
////    private byte[] imageBytes;
//    
//   
//    
//    private String imageUrl;
//    private String video;
//    @ManyToOne
//	private User user;
//    
//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//    
//    @JsonManagedReference
// 
//    private List<Comment> comments = new ArrayList<>();
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	
//
//	public Integer getShares() {
//		return shares;
//	}
//
//	public void setShares(Integer shares) {
//		this.shares = shares;
//	}
//
//	public Integer getLikes() {
//		return likes;
//	}
//
//	public void setLikes(Integer likes) {
//		this.likes = likes;
//	}
//
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//
//	public String getVideo() {
//		return video;
//	}
//
//	public void setVideo(String video) {
//		this.video = video;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//	//@JsonManagedReference
//	public List<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}
//
//	
//
//	public Post(int id, String content, Integer shares, Integer likes, String imageUrl, String video, User user,
//			List<Comment> comments) {
//		super();
//		this.id = id;
//		this.content = content;
//		this.shares = shares;
//		this.likes = likes;
//		this.imageUrl = imageUrl;
//		this.video = video;
//		this.user = user;
//		this.comments = comments;
//	}
//
//	public Post() {
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String toString() {
//		return "Post [id=" + id + ", content=" + content + ", shares=" + shares + ", likes=" + likes + ", imageUrl="
//				+ imageUrl + ", video=" + video + ", user=" + user + ", comments=" + comments + "]";
//	}
//	
//
//	
//    
//	
//

