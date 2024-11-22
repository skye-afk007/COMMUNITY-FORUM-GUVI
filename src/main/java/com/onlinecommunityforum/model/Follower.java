package com.onlinecommunityforum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
@SuppressWarnings("unused")
public class Follower {
    @Id
    @Column(name = "follower_id")
    private Long followerId;

    @Column(name = "followed_id")
    private Long followedId;

    @Column(name = "followed_at")
    private LocalDateTime followedAt;
}