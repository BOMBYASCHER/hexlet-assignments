package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    List<Post> index(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        return posts.subList((page - 1) * limit, limit * page);
    }

    @GetMapping("/posts/{id}")
    Optional<Post> show(@PathVariable String id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
    }

    @PostMapping("/posts")
    Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @PutMapping("/posts/{id}")
    Post update(@PathVariable String id, @RequestBody Post data) {
        var optionalPost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (optionalPost.isPresent()) {
            var post = optionalPost.get();
            post.setBody(data.getBody());
            post.setId(id);
            post.setTitle(data.getTitle());
        }
        return data;
    }

    @DeleteMapping("/posts/{id}")
    void delete(@PathVariable String id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
    // END
}
