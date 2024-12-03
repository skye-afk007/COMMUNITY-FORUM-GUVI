package com.onlinecommunityforum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinecommunityforum.dto.CommentDTO;
import com.onlinecommunityforum.entities.Comment;
import com.onlinecommunityforum.repositories.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(CommentDTO commentDTO) {
        // Convert DTO to Entity
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setPostId(commentDTO.getPostId());
        comment.setUserId(commentDTO.getUserId());
        
        // Save the comment to the database
        commentRepository.save(comment);
    }
}
