package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Category;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service.CategoryService;


@Controller
@RequiredArgsConstructor
public class CategoryAdminController {

    private final CategoryService categoryService;


    @GetMapping("/category-manager")
    public String getCategoryPage(Model model){

        model.addAttribute("categories", categoryService.findAllCategory());
        return "category-page";
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategory(@RequestParam(name = "name") String name,
                                  @RequestParam(name = "description") String description,
                                  @RequestParam(name = "image") String image
    )
    {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setImage(image);


        categoryService.saveCategory(category);

        return "redirect:/category-manager";
    }


    @PostMapping("/updateCategory")
    public String updateCategory(@RequestParam(name = "id") Category category,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "description") String description,
                                 @RequestParam(name = "linkCategory") String image
                                 ) {

        category.setName(name);
        category.setDescription(description);
        category.setImage(image);

        categoryService.updateCategory(category);

        return "redirect:/category-manager";
    }

    @PostMapping("/deleteCategory")
    public String updateCategory(@RequestParam(name = "id") Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/category-manager";
    }

}
