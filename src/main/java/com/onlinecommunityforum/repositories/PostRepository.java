package com.onlinecommunityforum.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinecommunityforum.model.Post;

@Repository
public interface PostRepository extends JpaRepository<com.onlinecommunityforum.model.Post, Long> {

    default Optional<Post> findPostById(Long id) {
        try {
            return findById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Database error while fetching post with ID: " + id, ex);
        }
    }
}
