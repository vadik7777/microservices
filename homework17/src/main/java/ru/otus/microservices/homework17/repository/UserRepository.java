package ru.otus.microservices.homework17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.microservices.homework17.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

}
