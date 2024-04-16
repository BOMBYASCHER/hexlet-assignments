package exercise;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

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
    ResponseEntity<List<Post>> index() {
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(posts);
    }

    @GetMapping("/posts/{id}")
    ResponseEntity<Post> show(@PathVariable String id) {
        var optionalPost = posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(optionalPost);
    }

    @PostMapping("/posts")
    ResponseEntity<Post> create(@RequestBody Post data) {
        posts.add(data);
        return ResponseEntity.status(201).body(data);
    }

    @PutMapping("/posts/{id}")
    ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post data) {
        var optionalPost = posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
        if (optionalPost.isPresent()) {
            var post = optionalPost.get();
            post.setId(data.getId());
            post.setBody(data.getBody());
            post.setTitle(data.getTitle());
            return ResponseEntity.ok().body(data);
        } else {
            return ResponseEntity.status(204).body(data);
        }
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
