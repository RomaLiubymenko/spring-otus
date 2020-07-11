package ru.otus.springcourse05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse05.domain.Books;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BooksDaoJdbc implements BooksDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public BooksDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private static RowMapper<Books> booksRowMapper = (resultSet, i) -> {
        int idBook = resultSet.getInt("idBook");
        int idAuthor = resultSet.getInt("idAuthor");
        int idGenre = resultSet.getInt("idGenre");
        int idPublishingHouse = resultSet.getInt("idPublishingHouse");
        String title = resultSet.getString("title");
        Date publicationYear = resultSet.getDate("publicationYear");
        int numberOfPages = resultSet.getInt("numberOfPages");
        return new Books(idBook, idAuthor, idGenre, idPublishingHouse, title, publicationYear, numberOfPages);
    };

    @Override
    public List<Books> getAll() {
        return jdbcOperations.query("SELECT * FROM Books", booksRowMapper);
    }

    @Override
    public int insert(Books books) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("idAuthor", books.getIdAuthor())
                .addValue("idPublishingHouse", books.getIdPublishingHouse())
                .addValue("idGenre", books.getIdGenre())
                .addValue("title", books.getTitle())
                .addValue("publicationYear", books.getPublicationYear())
                .addValue("numberOfPages", books.getNumberOfPages());
        return jdbcOperations.update("INSERT INTO Books VALUES( :idAuthor, :idGenre, :idPublishingHouse, :title, :publicationYear, :numberOfPages)", parameterSource);
    }

    @Override
    public int updateYearById(int id, Date year) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("year", year);
        return jdbcOperations.update("UPDATE Books SET publicationYear = :year WHERE idBook = :id", parameterSource);
    }

    @Override
    public int deleteById(int id) {
        return jdbcOperations.update("DELETE FROM Books WHERE idBook = :id", new MapSqlParameterSource("id", id));
    }

    @Override
    public Books getById(int id) {
        Map<String, Object> parameterSource =  Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject("SELECT * FROM Books WHERE idBook = :id", parameterSource, booksRowMapper);
    }


}
