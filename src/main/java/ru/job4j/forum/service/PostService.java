package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Collection<Post> getAll() {
        List<Post> res = new ArrayList<>();
        repository.findAll().forEach(res::add);
        return res;
    }

    public void save(Post post) {
        repository.save(post);
    }
}
