package com.onlinecommunityforum.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
@SuppressWarnings("unused")
public class SavedPost {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "saved_at")
    private LocalDateTime savedAt;
}


