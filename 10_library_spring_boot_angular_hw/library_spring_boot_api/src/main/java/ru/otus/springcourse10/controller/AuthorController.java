package ru.otus.springcourse10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.springcourse10.dto.AuthorDto;
import ru.otus.springcourse10.service.AuthorsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorsService authorsService;

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDto>> getAuthors() {
        List<AuthorDto> authorDtoList = authorsService.outputListOfAuthorsDto();
        if (authorDtoList != null && !authorDtoList.isEmpty()) {
            return new ResponseEntity<>(authorDtoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/author/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable("id") Integer id) {
        AuthorDto authorDto = authorsService.getAuthorDtoById(id);
        if (authorDto != null) {
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        authorsService.insertAuthorDto(authorDto);
        return new ResponseEntity<>(authorDto, HttpStatus.CREATED);
    }

}
