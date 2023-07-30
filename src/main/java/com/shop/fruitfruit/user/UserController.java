package com.shop.fruitfruit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.lang.String;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @RequestMapping("user/data")
    public String testSelect(){
        return "data";
    }
    @RequestMapping("user/axiosSelect") //비동기로 data 뿌려줌
    @ResponseBody
    public List<HashMap<String, Object>> axiosSelect(){

        return userService.testSelect();
    }


    @PostMapping ("signUp")
    public String signUp(@RequestParam HashMap<String, Object> requestData,
                         @RequestParam List<String> status, BCryptPasswordEncoder bCryptPasswordEncoder, Model model) {

        String encodedPassword = bCryptPasswordEncoder.encode((String)requestData.get("password")); // 비밀번호 암호화
        System.out.println(encodedPassword);
        requestData.put("status",status); // 약관 넘겨줌
        requestData.put("encodedPassword",encodedPassword); //암호화된 비밀번호 넘겨줌
        userService.insertUserTermAll(requestData); // 뷰에서 컨트롤러로 받은 값 서비스로 넘겨줌

        model.addAttribute("user_email",requestData.get("email"));

        return "user/joinConfirm";
    }

    @ResponseBody
    @PostMapping("/emailChk")
    public String emailChk(@RequestBody HashMap<String,Object> requestData){

        String emailChk = userService.emailChk(requestData); //서비스에서 반환된 값 넣어줌
        if(emailChk!=null) return "이미 가입된 계정입니다";
        else return null;
    }

    @ResponseBody
    @PostMapping("/nicknameChk")
    public String nicknameChk(@RequestBody HashMap<String,Object> requestData){

        String nicknameChk = userService.nicknameChk(requestData); //서비스에서 반환된 값 넣어줌

        if(nicknameChk!=null) return "해당 닉네임은 이미 사용중입니다";
        else return null;
    }

    @GetMapping("{pageName}")
    public String goSubPage(@PathVariable String pageName){
        return "user/"+pageName;
    }
}
