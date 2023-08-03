package com.shop.fruitfruit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class MainController {

    @GetMapping("/")
    public String Home(){return "index";}

    @RequestMapping("alert")
    @ResponseBody
    public String alertModal(@RequestBody HashMap<String,Object> param, Model model){
        model.addAttribute("title",param.get("title"));
        model.addAttribute("msg",param.get("msg"));
        return "modal/alert";
    }

    @GetMapping("/admin")
    public String adminIndex() {


        return "admin";
    }


}
