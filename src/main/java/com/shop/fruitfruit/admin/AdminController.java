package com.shop.fruitfruit.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {
    @GetMapping("/admin")
    public String adminMain(){

        return "/admin";
    }

    @GetMapping("/admin/dashboard")
    public String adminMainDash(){

        return "/admin/dashboard";
    }

    @GetMapping("/admin/member")
    public String adminMember(){

        return "/admin/member";
    }

}
