package com.onlinecommunityforum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinecommunityforum.dto.CommentDTO;
import com.onlinecommunityforum.model.Comment;
import com.onlinecommunityforum.repositories.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(CommentDTO commentDTO) {
        if (commentDTO == null || commentDTO.getContent() == null || commentDTO.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Comment content cannot be null or empty");
        }
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setPostId(commentDTO.getPostId());
        comment.setUserId(commentDTO.getUserId());
        try {
            commentRepository.save(comment);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to save comment: " + ex.getMessage());
        }
    }
}
