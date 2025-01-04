package com.onlinecommunityforum.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinecommunityforum.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> { 

    default Optional<Comment> findCommentById(Long id) { 
        try {
            return findById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Database error while fetching comment with ID: " + id, ex);
        }
    }
}
