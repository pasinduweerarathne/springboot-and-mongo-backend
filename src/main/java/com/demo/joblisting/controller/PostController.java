package com.demo.joblisting.controller;

import com.demo.joblisting.repository.PostRepository;
import com.demo.joblisting.model.Post;
import com.demo.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://locahost:3000")
public class PostController {
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    // @RequestMapping(value="/")
    // public void redirect(HttpServletResponse response) throws IOException {
    //    response.sendRedirect("/swagger-ui.html");
    // }

    @GetMapping("/posts")
    @CrossOrigin
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text) {
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post) {
        return repo.save(post);
    }

}
