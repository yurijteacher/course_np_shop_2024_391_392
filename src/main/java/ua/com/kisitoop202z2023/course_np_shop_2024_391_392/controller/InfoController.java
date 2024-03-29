package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Category;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.ProductRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service.CategoryService;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service.ProductService;

@Controller
@RequiredArgsConstructor
public class InfoController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/payment")
    public String getPagePayment(){
        return "payment";
    }

    @GetMapping("/delivery")
    public String getPageDelivery(){
        return "delivery";
    }


    @GetMapping("/info")
    public String getPageInfo(){
        return "info";
    }

    @GetMapping("/login")
    public String getPageLogin(){
        return "auth";
    }

//    @GetMapping("/category")
//    public String getPageCategory(Model model){
//
//        model.addAttribute("categories", categoryService.getAllCategory());
//
//        return "category";
//    }

    @GetMapping("/category")
    public String getPageCategory(Model model,
                                  @PageableDefault(sort = {"id"},
                                          direction = Sort.Direction.ASC, size = 2)
                                          Pageable pageable
                                  ){

        model.addAttribute("page", categoryService.getPageElCategory(pageable));

        model.addAttribute("url", "/category");

        return "category";
    }


//    @GetMapping("/category/{id}")
//    public String getProductsByCategory(@PathVariable("id") Category category,
//                                        Model model){
//
//        model.addAttribute("productByCategory", productService.findProductsByCategory(category));
//
//        return "products";
//    }

    @GetMapping("/category/{id}")
    public String getProductsByCategory(@PathVariable("id") Category category,
                                        Model model,
                                        @PageableDefault(sort = {"price"},
                                        direction = Sort.Direction.ASC, size = 3)
                                        Pageable pageable
                                        ){

       // model.addAttribute("productByCategory", productService.findProductsByCategory(category));
        model.addAttribute("page", productService.getPageProductsByCategory(pageable, category));

        model.addAttribute("url", "/category/"+category.getId());


        return "products";
    }


    @GetMapping("/search")
    public String getPageResultSearchProductByName(@RequestParam(name = "search") String name,
                                                   Model model){

        model.addAttribute("productByName", productRepository.findAllByNameContainsIgnoreCaseOrderByName(name));

        return "search";
    }



}
