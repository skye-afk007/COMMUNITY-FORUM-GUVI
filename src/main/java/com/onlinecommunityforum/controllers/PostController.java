package com.onlinecommunityforum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinecommunityforum.dto.PostDTO; // Ensure you have this DTO class
import com.onlinecommunityforum.services.PostService; // Ensure the service class exists

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody PostDTO postDTO) {
        postService.savePost(postDTO);
        return ResponseEntity.ok("Post added successfully!");
    }
}

