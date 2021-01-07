package ru.otus.springcourse10.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.otus.springcourse10.dto.BookDto;
import ru.otus.springcourse10.model.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    @Mappings({
            @Mapping(source = "idBook", target = "id"),
            @Mapping(source = "commentSet", target = "commentDtoSet"),
            @Mapping(source= "publicationYear", target = "publicationYear", dateFormat="yyyy-MM-dd"),
            @Mapping(source = "author", target = "authorDto"),
            @Mapping(source = "genre", target = "genreDto"),
            @Mapping(source = "publishingHouse", target = "publishingHouseDto")
    })
    BookDto bookToBookDto(Book book);

    @Mappings({
            @Mapping(target = "idBook", source = "id"),
            @Mapping(target = "commentSet", source = "commentDtoSet"),
            @Mapping(target= "publicationYear", source = "publicationYear", dateFormat="yyyy-MM-dd"),
            @Mapping(source = "authorDto", target = "author"),
            @Mapping(source = "genreDto", target = "genre"),
            @Mapping(source = "publishingHouseDto", target = "publishingHouse")
    })
    Book bookDtoToBook(BookDto bookDto);

    List<BookDto> booksToBookDtos(List<Book> bookList);
}
