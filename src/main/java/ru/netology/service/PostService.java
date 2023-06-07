package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.dto.PostDto;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<PostDto> all() {
        return findAllDto();
    }

    public PostDto getById(long id) {
        return getPostDtoById(id);
        //return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public PostDto save(Post post) {
        return savePost(post);
        //return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }

    public List<PostDto> findAllDto() {
        return repository.all().stream()
                .filter(x -> !x.getRemoved())
                .map(value -> new PostDto(value.getId(), value.getContent()))
                .collect(Collectors.toList());
    }

    public PostDto savePost(Post post) {
        repository.save(post);
        return new PostDto(post.getId(), post.getContent());
    }

    public PostDto getPostDtoById(long id) {
        Post post = repository.getById(id).orElseThrow(NotFoundException::new);
        return new PostDto(post.getId(), post.getContent());
    }
}

