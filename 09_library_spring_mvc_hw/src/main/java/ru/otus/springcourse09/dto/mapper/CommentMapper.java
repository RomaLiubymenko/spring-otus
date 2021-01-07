package ru.otus.springcourse09.dto.mapper;

import org.springframework.stereotype.Service;
import ru.otus.springcourse09.dto.CommentDto;
import ru.otus.springcourse09.model.Comment;

import java.util.List;

@Service
public class CommentMapper implements AbstractMapper<CommentDto, Comment> {

    @Override
    public Comment toEntity(CommentDto commentDto) {
        return null;
    }

    @Override
    public CommentDto toDto(Comment comment) {
        return null;
    }

    @Override
    public List<Comment> toEntity(List<CommentDto> commentDtos) {
        return null;
    }

    @Override
    public List<CommentDto> toDto(List<Comment> comments) {
        return null;
    }
}
