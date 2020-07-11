package ru.otus.springcourse05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse05.domain.PublishingHouses;

import java.util.List;

@Repository
public class PublishingHousesDaoJdbc implements PublishingHousesDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public PublishingHousesDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private static RowMapper<PublishingHouses> publishingHousesRowMapper = (resultSet, i) -> {
        int idPublishingHouse = resultSet.getInt("idPublishingHouse");
        String publishingName = resultSet.getString("publishingName");
        String country = resultSet.getString("country");
        return new PublishingHouses(idPublishingHouse, publishingName, country);
    };

    @Override
    public List<PublishingHouses> getAll() {
        return jdbcOperations.query("SELECT * FROM PublishingHouses", publishingHousesRowMapper);
    }

    @Override
    public PublishingHouses getById(int id) {
        return jdbcOperations.queryForObject("SELECT * FROM PublishingHouses WHERE idPublishingHouse = :id",
                new MapSqlParameterSource("id", id), publishingHousesRowMapper);

    }


    @Override
    public int insert(PublishingHouses publishingHouses) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("publishingName", publishingHouses.getPublishingName());
        parameterSource.addValue("country", publishingHouses.getCountry());
        return jdbcOperations.update("INSERT INTO PublishingHouses VALUES(:publishingName, :country)", parameterSource);
    }


}
