package kg.online_store.service;

import kg.online_store.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    void saveComment(Comment comment);
    Comment getCommentById(long id);
}
