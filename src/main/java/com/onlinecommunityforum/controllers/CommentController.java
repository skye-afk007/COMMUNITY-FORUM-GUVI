package com.onlinecommunityforum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinecommunityforum.dto.CommentDTO;
import com.onlinecommunityforum.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody CommentDTO commentDTO) {
        commentService.saveComment(commentDTO);
        return ResponseEntity.ok("Comment added successfully!");
    }
}
