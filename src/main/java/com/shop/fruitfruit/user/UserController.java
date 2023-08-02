package com.shop.fruitfruit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.lang.String;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("favicon.ico")
    @ResponseBody
    void noFavicon() {
    }

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
                         @RequestParam List<String> status,
                         BCryptPasswordEncoder bCryptPasswordEncoder,
                         RedirectAttributes redirectAttributes) {

        String encodedPassword = bCryptPasswordEncoder.encode((String)requestData.get("password")); // 비밀번호 암호화
        System.out.println(encodedPassword);
        requestData.put("status",status); // 약관 넘겨줌
        requestData.put("encodedPassword",encodedPassword); //암호화된 비밀번호 넘겨줌
        userService.insertUserTermAll(requestData); // 뷰에서 컨트롤러로 받은 값 서비스로 넘겨줌

        redirectAttributes.addAttribute("email", requestData.get("email"));

        return "redirect:joinConfirm";
    }

    @PostMapping("signIn")
    public String signIn(@RequestParam HashMap<String, Object> requestData,HttpServletResponse response, HttpSession session, Model model)  {

        HashMap<String, Object> result = userService.loginChk(requestData);

        String loginResult = (String) result.get("result");

//        System.out.println(result);

        if (loginResult.equals("success")) {
            model.addAttribute("email", requestData.get("email"));

            // 로그인 유지 체크 여부 확인
            if (requestData.containsKey("login_keep")) {
                // 쿠키에 이메일 저장 (유효 기간은 7일로 설정)
                Cookie emailCookie = new Cookie("email", (String) requestData.get("email"));
                emailCookie.setMaxAge(7 * 24 * 60 * 60); // 7일 (초 단위)
                response.addCookie(emailCookie);
            } else {
                // 로그인 유지를 체크하지 않았을 경우, 세션에 이메일 저장 쿠키 삭제
                session.setAttribute("email", (String) requestData.get("email"));
                Cookie emailCookie = new Cookie("email", null);
                emailCookie.setMaxAge(0);
                response.addCookie(emailCookie);
            }

            return "redirect:/"; // 로그인 성공 시 이동할 뷰 페이지
        } else if (loginResult.equals("fail")) {
            model.addAttribute("failMessage", "이메일과 비밀번호가 일치하지 않습니다.");
            return "user/login";
        } else if (loginResult.equals("fail2")) {
            model.addAttribute("fail2Message", "이메일이 존재하지 않습니다.");
            return "user/login";
        }

        return loginResult;
    }

    @ResponseBody
    @PostMapping("/emailChk")
    public String emailChk(@RequestBody HashMap<String,Object> requestData){

        HashMap<String,Object> emailChk = userService.emailChk(requestData); //서비스에서 반환된 값 넣어줌
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

    @PostMapping("adminSign")
    public String adminSign(@RequestParam HashMap<String, Object> requestData,HttpServletResponse response, HttpSession session, Model model)  {

        HashMap<String, Object> result = userService.loginChk(requestData);

        String loginResult = (String) result.get("result");

//        System.out.println(result);

        if (loginResult.equals("success")) {
            model.addAttribute("email", requestData.get("email"));

            // 로그인 유지 체크 여부 확인
            if (requestData.containsKey("login_keep")) {
                // 쿠키에 이메일 저장 (유효 기간은 7일로 설정)
                Cookie emailCookie = new Cookie("email", (String) requestData.get("email"));
                emailCookie.setMaxAge(7 * 24 * 60 * 60); // 7일 (초 단위)
                response.addCookie(emailCookie);
            } else {
                // 로그인 유지를 체크하지 않았을 경우, 세션에 이메일 저장 쿠키 삭제
                session.setAttribute("email", (String) requestData.get("email"));
                Cookie emailCookie = new Cookie("email", null);
                emailCookie.setMaxAge(0);
                response.addCookie(emailCookie);
            }

            return "redirect:admin/dashboard"; // 로그인 성공 시 이동할 뷰 페이지
        } else if (loginResult.equals("fail")) {
            model.addAttribute("failMessage", "이메일과 비밀번호가 일치하지 않습니다.");
            return "admin";
        } else if (loginResult.equals("fail2")) {
            model.addAttribute("fail2Message", "이메일이 존재하지 않습니다.");
            return "admin";
        }

        return loginResult;
    }

    @GetMapping("{pageName}")
    public String goSubPage(@PathVariable String pageName){
        return "user/"+pageName;
    }

}
