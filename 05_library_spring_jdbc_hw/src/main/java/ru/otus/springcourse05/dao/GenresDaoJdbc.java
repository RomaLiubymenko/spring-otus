package ru.otus.springcourse05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse05.domain.Genres;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class GenresDaoJdbc implements GenresDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public GenresDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private static RowMapper<Genres> genresRowMapper = (resultSet, i) -> {
        int idGenre = resultSet.getInt("idGenre");
        String nameGenre = resultSet.getString("nameGenre");
        return new Genres(idGenre, nameGenre);
    };

    @Override
    public List<Genres> getAll() {
        return jdbcOperations.query("SELECT * FROM Genres", genresRowMapper);
    }

    @Override
    public Genres getById(int id) {
        Map<String, Object> parametrSource = Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject("SELECT * FROM Genres WHERE idGenre = :id", parametrSource, genresRowMapper);
    }

    @Override
    public int insert(Genres genres) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("nameGenre", genres.getNameGenre());
        return jdbcOperations.update("INSERT INTO Genres VALUES(:nameGenre)", parameterSource);
    }

}
