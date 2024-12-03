package com.onlinecommunityforum.dto;

public class CommentDTO {

    

    private String content;    // The content of the comment
    private int postId;        // The ID of the post to which this comment belongs
    private int userId;        // The ID of the user making the comment

    // Default constructor
    public CommentDTO() {}

    // Parameterized constructor
    public CommentDTO(String content, int postId, int userId) {
        this.content = content;
        this.postId = postId;
        this.userId = userId;
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
