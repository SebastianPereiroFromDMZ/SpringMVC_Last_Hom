package ru.netology.mapping;

import ru.netology.dto.PostDto;
import ru.netology.model.Post;

public class MappingUtils {

    public PostDto mapToProductDto(Post post) {
        PostDto dto = new PostDto(post.getId(), post.getContent());
        return dto;
    }
}
