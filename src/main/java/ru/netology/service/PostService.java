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

  public List<Post> all() {
    return repository.all();
  }

  public Post getById(long id) {
    return repository.getById(id).orElseThrow(NotFoundException::new);
  }

  public Post save(Post post) {
    return repository.save(post);
  }

  public void removeById(long id) {
    repository.removeById(id);
  }

  public List<PostDto> findAllDto() {
    return repository.all().stream() //создали из листа стирим
            .filter(x -> x.getRemoved() == false)
            //оператором из streamAPI map, использовали для каждого элемента метод mapToProductDto из класса MappingUtils
            .collect(Collectors.toList()); //превратили стрим обратно в коллекцию, а точнее в лист
  }

  //для одиночного продукта обошлись проще
  public ProductDto findById(Integer id) {
    return mappingUtils.mapToProductDto( //в метод mapToProductDto
            productRepository.findById(id) //поместили результат поиска по id
                    .orElse(new ProductEntity()) //если ни чего не нашли, то вернем пустой entity
    );
  }
}

