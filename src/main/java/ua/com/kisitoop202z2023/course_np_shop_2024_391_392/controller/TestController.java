package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service.CategoryService;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public String getPageHome(Model model,
                              @PageableDefault(sort = {"id"},
                                      direction = Sort.Direction.ASC, size = 2)
                              Pageable pageable
    ){

        model.addAttribute("page", categoryService.getPageElCategory(pageable));

        model.addAttribute("url", "/category");
        return "category";
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
