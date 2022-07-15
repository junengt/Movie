package com.movie.repository;

import com.movie.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void userTest() throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setEmail("email");
        user.setPassword("password");
        userRepository.save(user);

        User findUser = userRepository.findById(user.getId()).get();

        Assertions.assertThat(user).isEqualTo(findUser);

    }
}