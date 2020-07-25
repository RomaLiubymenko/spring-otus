package ru.otus.springcourse09.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.otus.springcourse09.dto.AuthorDto;
import ru.otus.springcourse09.service.AuthorsService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorsService authorsService;

    @GetMapping("/author/{id}")
    public String viewAuthorById(@PathVariable("id") Integer id, Model model){
        AuthorDto authorDto = authorsService.getAuthorDtoById(id);
        model.addAttribute("authorDtos", authorDto);
        return "author-list";
    }

    @GetMapping("/author/")
    public String viewAllAuthors(Model model){
        List<AuthorDto> authorDtoList = authorsService.outputListOfAuthorsDto();
        model.addAttribute("authorDtos", authorDtoList);
        return "author-list";
    }

    @PostMapping("/author/add")
    public String addAuthor(Model model, @ModelAttribute("author") AuthorDto authorDto){
        authorsService.insertAuthorDto(authorDto);
        return "author-add";
    }

    @GetMapping(value = {"/author/add"})
    public String showAddAuthor(Model model) {
        AuthorDto authorDto = new AuthorDto();
        model.addAttribute("author", authorDto);
        return "author-add";
    }


}
