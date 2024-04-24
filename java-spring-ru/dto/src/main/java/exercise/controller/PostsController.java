package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    private PostDTO toDTO(Post post) {
        var postDTO = new PostDTO();
        var id = post.getId();
        postDTO.setId(id);
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());
        var comments = commentRepository.findByPostId(id)
                .stream()
                .map(comment -> {
                    var commentDTO = new CommentDTO();
                    commentDTO.setId(comment.getId());
                    commentDTO.setBody(comment.getBody());
                    return commentDTO;
                })
                .toList();
        postDTO.setComments(comments);
        return postDTO;
    }

    @GetMapping
    public List<PostDTO> index() {
        return postRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return toDTO(post);
    }
}
// END
