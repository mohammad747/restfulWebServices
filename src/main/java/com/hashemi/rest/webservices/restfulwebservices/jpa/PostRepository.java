package com.hashemi.rest.webservices.restfulwebservices.jpa;

import com.hashemi.rest.webservices.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
