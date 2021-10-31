package kg.online_store.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import jdk.jfr.Registered;
import kg.online_store.model.Comment;
import kg.online_store.service.CommentService;
import kg.online_store.service.ProductService;
import kg.online_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comment")
@CrossOrigin
@Api(description = "Контроллер для коментарии")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;


    @PostMapping("/{product-id}/{user-id}")
    @Operation(summary = "Добавление комментарии", description = "Позволяет добавить коментарии в базу данных")

    public ResponseEntity<?> saveComment(
            @RequestBody Comment comment,
            @PathVariable("product-id") long productId,
            @PathVariable("user-id") long userId) {
        try {
            commentService.save(comment, productId, userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
