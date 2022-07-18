package com.movie.service.user;

import com.movie.dto.UserJoinDto;
import com.movie.entity.User;
import com.movie.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void joinUser() throws Exception {
        //given: 이런 게 주어졌을 때
        UserJoinDto dto = new UserJoinDto();
        dto.setEmail("email1");
        dto.setPassword("password1");
        dto.setUsername("username1");

        //when: 이렇게 하면
        User joinUser = userService.joinUser(dto);

        //then: 이렇게 된다
        assertThat(joinUser.getEmail()).isEqualTo(dto.getEmail());
        assertThat(joinUser.getPassword()).isEqualTo(dto.getPassword());
        assertThat(joinUser.getUsername()).isEqualTo(dto.getUsername());
    }

    @Test
    void joinUserTwo() throws Exception {
        //given: 이런 게 주어졌을 때
        UserJoinDto dtoOne = new UserJoinDto();
        dtoOne.setEmail("email1");
        dtoOne.setPassword("password1");
        dtoOne.setUsername("username1");

        UserJoinDto dtoTwo = new UserJoinDto();
        dtoTwo.setEmail("email2");
        dtoTwo.setPassword("password2");
        dtoTwo.setUsername("username2");

        //when: 이렇게 하면
        User joinUserOne = userService.joinUser(dtoOne);
        User joinUserTwo = userService.joinUser(dtoTwo);

        //then: 이렇게 된다
        assertThat(joinUserOne.getId()).isEqualTo(1l);
        assertThat(joinUserTwo.getId()).isEqualTo(2l);
    }

}