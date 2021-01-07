package ru.otus.springcourse07.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse07.domain.Comment;
import ru.otus.springcourse07.repository.CommentsRepository;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public void insertComment(Comment comment) {
        commentsRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByBookTitle(String title) {
        return commentsRepository.findAllByBook_Title(title);
    }

    @Override
    public List<Comment> outputListOfComment() {
        return commentsRepository.findAll();
    }

    @Override
    public Comment getCommentById(int id) {
        return commentsRepository.getOne(id);
    }
}
