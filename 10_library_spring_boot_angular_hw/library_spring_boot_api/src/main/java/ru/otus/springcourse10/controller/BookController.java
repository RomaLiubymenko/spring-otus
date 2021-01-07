package ru.otus.springcourse10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.springcourse10.dto.BookDto;
import ru.otus.springcourse10.service.BooksService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BooksService booksService;

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Integer id){
        BookDto bookDto = booksService.getBookDtoById(id);
        if(bookDto != null){
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> bookDtoList = booksService.outputListOfBooksDtos();
        if (bookDtoList != null && !bookDtoList.isEmpty()){
            return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/books")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        booksService.insertBookDto(bookDto);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }

    /*@PutMapping("/book/{id}")
    public ResponseEntity<BookDto> updateBookDtoById(@PathVariable("id") Integer id){

    }*/

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable("id") Integer id){
        if(booksService.getBookDtoById(id) != null){
            booksService.deleteBookDtoById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
























}
