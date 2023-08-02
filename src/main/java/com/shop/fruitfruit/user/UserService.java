package com.shop.fruitfruit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public HashMap<String,Object> emailChk(HashMap<String, Object> requestData) {
        return userMapper.emailChk(requestData);
    }
    @Override
    public String nicknameChk(HashMap<String,Object> requestData) {return userMapper.nicknameChk(requestData); }

    @Override
    public HashMap<String, Object> loginChk(HashMap<String, Object> requestData) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        HashMap<String, Object> user = userMapper.emailChk(requestData);
        HashMap<String, Object> result = new HashMap<>();

        if (user == null) {
            result.put("result", "fail2");
            return result;
        }

        String encodedPassword = (String) user.get("password");

        String newPassword = (String)requestData.get("password");

        System.out.println("매치 결과 "+bCryptPasswordEncoder.matches(newPassword, encodedPassword));
        System.out.println("서비스쪽 user"+user);
        if (user != null) {
            // 아이디가 존재하면 비밀번호 확인

            if (bCryptPasswordEncoder.matches(newPassword,encodedPassword)) {

                // 비밀번호가 일치하면 로그인 성공
                result.put("result", "success");
                System.out.println("매칭성공");
            } else {
                // 비밀번호가 일치하지 않으면 로그인 실패
                result.put("result", "fail");
                System.out.println("매칭실패");
            }
        } else {
            // 아이디가 존재하지 않으면 로그인 실패
            result.put("result", "fail2");
        }

        return result;
    }
}
