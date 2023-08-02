package com.shop.fruitfruit.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    @GetMapping("/admin")
    public String adminMain(){

        return "/admin";
    }

    @GetMapping("/admin/dashboard")
    public String adminMainDash(){

        return "/admin/dashboard";
    }

    @GetMapping("/admin/banner")
    public String adminBanner(){

        return "/admin/banner";
    }

    @GetMapping("/admin/notification")
    public String adminNotification(){

        return "/admin/notification";
    }
    @GetMapping("/admin/member")
    public String adminMember(){

        return "/admin/member";
    }


}
