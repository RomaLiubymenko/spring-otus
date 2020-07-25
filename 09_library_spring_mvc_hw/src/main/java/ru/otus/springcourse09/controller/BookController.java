package ru.otus.springcourse09.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.springcourse09.dto.BookDto;
import ru.otus.springcourse09.service.BooksService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BooksService booksService;

    @GetMapping("/book/{id}")
    public String viewBookById(@PathVariable("id") Integer id, Model model){
        BookDto bookDto = booksService.getBookDtoById(id);
        model.addAttribute("bookDtos", bookDto);
        return "book-list";
    }

    @GetMapping("/book/")
    public String viewAllBooks(Model model){
        List<BookDto> bookDtoList = booksService.outputListOfBooks();
        model.addAttribute("bookDtos", bookDtoList);
        return "book-list";
    }
}
