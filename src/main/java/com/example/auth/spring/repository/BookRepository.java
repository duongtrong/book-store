package com.example.auth.spring.repository;

import com.example.auth.spring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b " + "where (:name is null or b.name like concat('%', :name, '%'))" +
            " or (:genre is null or b.genre like concat('%', :genre, '%')) " +
            "or (:author is null or b.author like concat('%', :author, '%'))")
    List<Book> findBooksByTitleAndAndAuthorAndGenre(@Param ("title") String title, @Param ("author") String author, @Param ("genre") String genre);
}
