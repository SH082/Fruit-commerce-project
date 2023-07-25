package com.shop.fruitfruit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserMapper {
    private final UserMapper userMapper;
}
