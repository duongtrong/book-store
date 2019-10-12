package com.example.auth.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "book")
@AllArgsConstructor
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "title")
        @NotNull
        private String title;

        @Column(name = "author")
        @NotNull
        private String author;

        @NotNull
        @Column(name = "publisher")
        private String publisher;

        @Column(name = "genre")
        @NotNull
        private String genre;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDateTime createdAt;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDateTime updatedAt;

        private int  status;

        public Book() {
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
            this.status = 1;
        }
}
