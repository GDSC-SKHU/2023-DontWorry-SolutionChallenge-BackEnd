package com.example.dontworry.web.service;

import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.domain.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostsRepository postsRepository;
    public Posts addPosts(Posts posts){
        return postsRepository.save(posts);
    }
}
