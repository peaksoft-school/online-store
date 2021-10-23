package kg.online_store.service;

import kg.online_store.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment, long productId, long userId);
}
