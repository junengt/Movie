package com.movie.repository;

import com.movie.entity.User;
import com.movie.repository.user.UserRepository;
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

        //임의의 User 생성
        User user = new User("test", "test", "test");

        //생성된 User 저장
        userRepository.save(user);

        //생성된 User의 id값을 가지고 유저 찾기
        User findUser = userRepository.findById(user.getId()).get();

        //생성한 User와 찾은 User 검증 -> 성공해야함
        Assertions.assertThat(user).isEqualTo(findUser);
    }

}