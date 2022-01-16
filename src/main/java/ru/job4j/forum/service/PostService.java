package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.Collection;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Collection<Post> findAllPost() {
        return repository.getAllPost();
    }

    public void savePost(Post post) {
        repository.save(post);
    }

    public Post findById(int id) {
        return repository.findById(id);
    }
}
