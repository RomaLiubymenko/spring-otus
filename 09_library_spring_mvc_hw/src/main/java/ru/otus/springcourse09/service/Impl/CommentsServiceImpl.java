package ru.otus.springcourse09.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse09.model.Comment;
import ru.otus.springcourse09.repository.CommentsRepository;
import ru.otus.springcourse09.service.CommentsService;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

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
