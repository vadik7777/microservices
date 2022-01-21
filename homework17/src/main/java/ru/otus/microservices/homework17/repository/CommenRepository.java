package ru.otus.microservices.homework17.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.otus.microservices.homework17.domain.Comment;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface CommenRepository extends JpaRepository<Comment, Long> {

    @EntityGraph(attributePaths = "book")
    Optional<Comment> findById(long id);

    List<Comment> findCommentByBookId(long bookId);
}