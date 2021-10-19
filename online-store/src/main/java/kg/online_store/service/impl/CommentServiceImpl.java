package kg.online_store.service.impl;

import kg.online_store.model.Comment;
import kg.online_store.repository.CommentRepository;
import kg.online_store.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(long id) {
        return commentRepository.getById(id);
    }

}
