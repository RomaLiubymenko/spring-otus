package ru.otus.springcourse09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.springcourse09.model.Book;

import java.sql.Date;

public interface BooksRepository extends JpaRepository<Book, Integer> {

    @Modifying
    @Query("UPDATE Book book set book.publicationYear = :year where book.idBook = :id")
    void updateYearBookById(@Param("id") int id, @Param("year")  Date year);
}
