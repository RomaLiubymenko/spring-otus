package ru.otus.springcourse06.service;

import org.springframework.stereotype.Service;
import ru.otus.springcourse06.domain.Comment;
import ru.otus.springcourse06.repository.CommentsRepository;

import java.util.List;


@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public void insertComment(Comment comment) {
        commentsRepository.insert(comment);
    }

    @Override
    public List<Comment> outputListOfComment() {
        return commentsRepository.getAll();
    }

    @Override
    public Comment getCommentById(int id) {
        return commentsRepository.getById(id);
    }
}
