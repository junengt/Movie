package com.movie.service.user;

import com.movie.dto.UserJoinDto;
import com.movie.entity.User;
import com.movie.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    //생성자 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //회원 가입
    public User joinUser(UserJoinDto userJoinDto) {
        User user = User.builder()
                .email(userJoinDto.getEmail())
                .password(userJoinDto.getPassword())
                .username(userJoinDto.getUsername())
                .build();
        userRepository.save(user);
        return user;
    }

    //로그인

}