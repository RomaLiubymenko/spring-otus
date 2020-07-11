package ru.otus.springcourse05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse05.domain.Authors;

import java.util.List;

@Repository
public class AuthorsDaoJdbc implements AuthorsDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public AuthorsDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private static RowMapper<Authors> authorsMapper = (resultSet, i) -> {
        int idAuthor = resultSet.getInt("idAuthor");
        String firstname = resultSet.getString("firstname");
        String lastname = resultSet.getString("lastname");
        String country = resultSet.getString("country");
        return new Authors(idAuthor, firstname, lastname, country);
    };

    @Override
    public List<Authors> getAll() {
        return jdbcOperations.query("SELECT * FROM Authors", authorsMapper);
    }

    @Override
    public Authors getById(int id) {
        return jdbcOperations.queryForObject("SELECT * FROM Authors WHERE idAuthor = :id",
                new MapSqlParameterSource("id", id), authorsMapper);

    }

    @Override
    public int insert(Authors authors) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("firstname", authors.getFirstname())
                .addValue("lastname", authors.getLastname())
                .addValue("country", authors.getCountry());
        return jdbcOperations.update("INSERT INTO Authors VALUES(:firstname,:lastname,:country)", parameterSource);

    }


}
