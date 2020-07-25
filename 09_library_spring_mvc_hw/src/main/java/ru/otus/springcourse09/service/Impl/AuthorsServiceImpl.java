package ru.otus.springcourse09.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse09.dto.AuthorDto;
import ru.otus.springcourse09.dto.mapper.AuthorMapper;
import ru.otus.springcourse09.model.Author;
import ru.otus.springcourse09.repository.AuthorsRepository;
import ru.otus.springcourse09.service.AuthorsService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorsRepository authorsRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorDto getAuthorDtoById(int id) {
        Author author = authorsRepository.getOne(id);
        return authorMapper.authorToAuthorDto(author);
    }

    @Override
    public void insertAuthorDto(AuthorDto authorDto) {
        Author author = authorMapper.authorDtoToAuthor(authorDto);
        authorsRepository.save(author);
    }

    @Override
    public List<AuthorDto> outputListOfAuthorsDto() {
        List<Author> authorList =  authorsRepository.findAll();
        return authorMapper.authorsToAuthorDtos(authorList);
    }
}
