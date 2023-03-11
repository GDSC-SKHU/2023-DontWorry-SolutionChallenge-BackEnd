package com.example.dontworry.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dontworry.domain.posts.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long>,PostsRepositoryCustom {

}


