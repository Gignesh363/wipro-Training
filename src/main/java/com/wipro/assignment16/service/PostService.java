package com.wipro.assignment16.service;

import com.wipro.assignment16.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class PostService {

    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;

    // GET all posts
    public Post[] getAllPosts() {
        return restTemplate.getForObject(API_URL, Post[].class);
    }

    // GET single post by ID
    public Post getPostById(Long id) {
        return restTemplate.getForObject(API_URL + "/" + id, Post.class);
    }

    // POST - Create new post
    public Post createPost(Post post) {
        return restTemplate.postForObject(API_URL, post, Post.class);
    }

    // PUT - Update post
    public void updatePost(Long id, Post post) {
        restTemplate.put(API_URL + "/" + id, post);
    }

    // DELETE post
    public void deletePost(Long id) {
        restTemplate.delete(API_URL + "/" + id);
    }
}
