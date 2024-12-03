package com.onlinecommunityforum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
@SuppressWarnings("unused")
public class PostTag {
    @Id
    @Column(name = "post_id")
    private Long postId;

    @Id
    @Column(name = "tag_id")
    private Long tagId;
}