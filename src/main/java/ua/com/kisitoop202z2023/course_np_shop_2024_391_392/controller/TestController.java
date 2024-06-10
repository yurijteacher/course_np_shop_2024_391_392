package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String getPageHome(Model model){

        model.addAttribute("hello", "Hello Student!!!");
        return "index";
    }


    @GetMapping("/user")
    public String getUserPage(){
        return "user-page";
    }

    @GetMapping("/manager")
    public String getManagerPage(//Model model
    ){

//        model.addAttribute("categories", categoryRepository.findAll());
        return "manager-page";
    }

    @GetMapping("/admin")
    public String getPageAdmin(){
        return "admin-page";
    }

    @GetMapping("/order-manager")
    public String getOrderPage(){
        return "order-page";
    }



}
