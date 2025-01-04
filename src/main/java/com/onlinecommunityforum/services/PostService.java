package com.onlinecommunityforum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinecommunityforum.dto.PostDTO;
import com.onlinecommunityforum.model.Post;
import com.onlinecommunityforum.repositories.PostRepository;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void savePost(PostDTO postDTO) {
        if (postDTO == null || postDTO.getTitle() == null || postDTO.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Post title cannot be null or empty");
        }
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        try {
            postRepository.save(post);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to save post: " + ex.getMessage());
        }
    }

    public Post getPostById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Post ID cannot be null");
        }
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new IllegalArgumentException("Post not found with ID: " + id));
    }
}
