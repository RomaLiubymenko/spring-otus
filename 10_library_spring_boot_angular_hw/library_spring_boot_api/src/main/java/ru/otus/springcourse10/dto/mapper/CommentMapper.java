package ru.otus.springcourse10.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.otus.springcourse10.dto.CommentDto;
import ru.otus.springcourse10.model.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Mappings({
            @Mapping(source = "idComment", target = "id"),
            @Mapping(source = "book", target = "bookDto"),
            @Mapping(source = "publicationTime", target = "publicationTime", dateFormat = "yyyy-MM-dd HH:mm")
    })
    CommentDto commentToCommentDto(Comment comment);

    @Mappings({
            @Mapping(source = "id", target = "idComment"),
            @Mapping(source = "bookDto", target = "book"),
            @Mapping(source = "publicationTime", target = "publicationTime", dateFormat = "yyyy-MM-dd HH:mm")
    })
    Comment commentDtoToComment(CommentDto commentDto);

    List<CommentDto> commentsToCommentDtos(List<Comment> commentList);

}
