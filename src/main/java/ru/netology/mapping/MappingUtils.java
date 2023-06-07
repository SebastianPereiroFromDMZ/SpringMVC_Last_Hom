package ru.netology.mapping;

import ru.netology.dto.PostDto;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MappingUtils {

    public List<PostDto> findAllDto(PostRepository repository) {
        return repository.all().stream()
                .filter(x -> !x.getRemoved())
                .map(value -> new PostDto(value.getId(), value.getContent()))
                .collect(Collectors.toList());
    }

    public PostDto savePost(PostRepository repository, Post post) {
        repository.save(post);
        return new PostDto(post.getId(), post.getContent());
    }

    public PostDto getPostDtoById(PostRepository repository, long id) {
        Post post = repository.getById(id).orElseThrow(NotFoundException::new);
        if (!post.getRemoved()) {
            return new PostDto(post.getId(), post.getContent());
        } else {
            throw new NotFoundException();
        }
    }
}
