package com.shop.fruitfruit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserMapper{

    private final UserMapper userMapper;

    @Override
    public List<HashMap<String, Object>> testSelect() {
        return userMapper.testSelect();
    }

    public void insertUserTermAll(HashMap<String, Object> requestData) {
        userMapper.insertUser(requestData);
        userMapper.insertUserTerm(requestData);
    }

    @Override
    public void insertUserTerm(HashMap<String, Object> requestData) {}

    @Override
    public void insertUser(HashMap<String, Object> requestData) {}

    //파라미터로 컨트롤러에서 값 전달 받고, 값 넘김. 그리고 매퍼 값 다시 리턴 받음
    @Override
    public String emailChk(HashMap<String,Object> requestData) {return userMapper.emailChk(requestData); }
    @Override
    public String nicknameChk(HashMap<String,Object> requestData) {return userMapper.nicknameChk(requestData); }

}
