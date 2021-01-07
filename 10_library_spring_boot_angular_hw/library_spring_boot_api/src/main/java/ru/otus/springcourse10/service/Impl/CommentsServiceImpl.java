package ru.otus.springcourse10.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse10.dto.CommentDto;
import ru.otus.springcourse10.dto.mapper.CommentMapper;
import ru.otus.springcourse10.model.Comment;
import ru.otus.springcourse10.repository.CommentsRepository;
import ru.otus.springcourse10.service.CommentsService;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;
    private final CommentMapper commentMapper;

    @Override
    public void insertCommentDto(CommentDto commentDto) {
        Comment comment = commentMapper.commentDtoToComment(commentDto);
        commentsRepository.save(comment);
    }

    @Override
    public List<CommentDto> getCommentDtosByBookTitle(String title) {
        List<Comment> commentList = commentsRepository.findAllByBook_Title(title);
        return commentMapper.commentsToCommentDtos(commentList);
    }

    @Override
    public List<CommentDto> outputListOfCommentDto() {
        List<Comment> commentList = commentsRepository.findAll();
        return commentMapper.commentsToCommentDtos(commentList);
    }

    @Override
    public CommentDto getCommentDtoById(int id) {
        Comment comment = commentsRepository.getOne(id);
        return commentMapper.commentToCommentDto(comment);
    }
}
