package com.wipro.assignment16.controller;

import com.wipro.assignment16.model.Post;
import com.wipro.assignment16.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // GET all posts
    @GetMapping
    public Post[] getAllPosts() {
        return postService.getAllPosts();
    }

    // GET single post
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    // POST - Create post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // PUT - Update post
    @PutMapping("/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody Post post) {
        postService.updatePost(id, post);
        return "Post updated successfully!";
    }

    // DELETE - Delete post
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "Post deleted successfully!";
    }
}
