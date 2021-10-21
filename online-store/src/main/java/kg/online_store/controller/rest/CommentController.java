package kg.online_store.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import kg.online_store.model.Comment;
import kg.online_store.service.CommentService;
import kg.online_store.service.ProductService;
import kg.online_store.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comment")
@CrossOrigin
@Api(description = "Контроллер для коментарии")
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;
    private final ProductService productService;

    public CommentController(CommentService commentService, UserService userService, ProductService productService) {
        this.commentService = commentService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/{product-id}/{user-id}")
    @Operation(summary = "Добавление комментарии", description = "Позволяет добавить коментарии в базу данных")

    public ResponseEntity<?> saveComment(@RequestBody Comment comment, @PathVariable("product-id") long productId, @PathVariable("user-id") long userId) {
        try {
            comment.setUser(userService.findById(userId));
            comment.setProduct(productService.findById(productId));
            commentService.saveComment(comment);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
