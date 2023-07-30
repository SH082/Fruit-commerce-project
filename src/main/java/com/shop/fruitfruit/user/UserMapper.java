package com.shop.fruitfruit.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    List<HashMap<String, Object>> testSelect(); //TEST 용

    void insertUserTerm(HashMap<String, Object> requestData);

    void insertUser(HashMap<String, Object> requestData);

    //쿼리에 넘겨줄 값 서비스로부터 전달 받음
    String emailChk(HashMap<String,Object> requestData);

    String nicknameChk(HashMap<String,Object> requestData);
}
