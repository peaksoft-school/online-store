package kg.online_store.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import kg.online_store.model.Comment;
import kg.online_store.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin
@Api(description = "Контроллер для коментарии")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        try {
            return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
        }catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @Operation(summary = "Добавление комментарии", description = "Позволяет добавить коментарии в базу данных")
    public ResponseEntity<?> saveComment(@RequestBody Comment comment) {
        try {
            commentService.saveComment(comment);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
