package kg.online_store.service.impl;

import kg.online_store.model.Comment;
import kg.online_store.repository.CommentRepository;
import kg.online_store.service.CommentService;
import kg.online_store.service.ProductService;
import kg.online_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public void save(Comment comment, long productId, long userId) {
        comment.setDate(LocalDate.now());
        comment.setUser(userService.findById(userId));
        comment.setProduct(productService.findById(productId));
        commentRepository.save(comment);
    }

}
