package ru.otus.microservices.homework17.repository;

import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.otus.microservices.homework17.domain.Role;
import ru.otus.microservices.homework17.domain.RoleName;
import ru.otus.microservices.homework17.domain.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий для работы с пользователями должен")
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("получать пользователя по имени")
    @Test
    void shouldCorrectFindByName() {
        val expectedUser = new User(1, "admin",
                "$2a$12$DccKMGc3RRKY12mW1DVFe.a5qtitu2ex9EmUGxWkVD44T3SsUdnFS",
                List.of(new Role(1, RoleName.ROLE_ADMIN)));
        val actualUser = userRepository.findByUserName("admin").orElseThrow();
        Assertions.assertThat(actualUser).usingRecursiveComparison().isEqualTo(expectedUser);
    }
}