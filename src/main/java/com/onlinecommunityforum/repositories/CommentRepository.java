package com.onlinecommunityforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinecommunityforum.entities.Comment;  // Ensure the correct import of the Comment entity

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    // You can add custom query methods here if needed
}
