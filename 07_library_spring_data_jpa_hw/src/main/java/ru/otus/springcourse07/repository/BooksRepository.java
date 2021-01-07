package ru.otus.springcourse07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse07.domain.Book;

import java.sql.Date;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

    @Modifying
    @Query("UPDATE Book book set book.publicationYear = :year where book.idBook = :id")
    void updateYearBookById(@Param("id") int id, @Param("year")  Date year);
}
