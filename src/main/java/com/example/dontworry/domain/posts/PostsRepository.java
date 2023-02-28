package com.example.dontworry.domain.posts;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.argumentresolver.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Long> {
}

