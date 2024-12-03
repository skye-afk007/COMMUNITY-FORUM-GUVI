package com.onlinecommunityforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {}
