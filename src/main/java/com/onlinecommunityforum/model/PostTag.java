package com.onlinecommunityforum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
@SuppressWarnings("unused")
public class PostTag {
    @Id
    @Column(name = "post_id")
    private Long postId;

    @Id
    @Column(name = "tag_id")
    private Long tagId;
}


