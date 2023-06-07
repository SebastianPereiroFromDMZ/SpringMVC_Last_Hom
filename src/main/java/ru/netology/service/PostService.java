package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.dto.PostDto;
import ru.netology.mapping.MappingUtils;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;
import java.util.List;


@Service
public class PostService {
    private final PostRepository repository;
    private final MappingUtils mapping;

    public PostService(PostRepository repository) {
        this.repository = repository;
        mapping = new MappingUtils();
    }

    public List<PostDto> all() {
        return mapping.findAllDto(repository);
    }

    public PostDto getById(long id) {
        return mapping.getPostDtoById(repository,id);
    }

    public PostDto save(Post post) {
        return mapping.savePost(repository,post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }

    public List<Post> allPosts(){
        return repository.all();
    }
}

