package com.onlinecommunityforum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinecommunityforum.dto.PostDTO;
import com.onlinecommunityforum.entities.Post;
import com.onlinecommunityforum.repositories.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());   // Works if getters/setters are defined in PostDTO and Post
        post.setContent(postDTO.getContent());
        post.setUserId(postDTO.getUserId());
        postRepository.save(post);
    }
}
