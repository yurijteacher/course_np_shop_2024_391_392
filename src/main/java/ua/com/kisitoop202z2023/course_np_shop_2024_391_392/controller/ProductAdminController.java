package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Category;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Product;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service.CategoryService;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service.ProductService;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class ProductAdminController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/product-manager")
    public String productManager(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.findAllCategory());

        return "product-page";
    }


    @PostMapping("/saveProductToDb")
    public String saveProductToDb(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "image") String image,
            @RequestParam(name = "price") double price,
            @RequestParam(name = "categoryId") Category category
            ) {

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setCategories(category);
        product.setPrice(new BigDecimal(price));
        product.setImage(image);

        productService.createProduct(product);

        return "redirect:/product-manager";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(
            @RequestParam(name = "id") Product product,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "image") String image,
            @RequestParam(name = "price") double price,
            @RequestParam(name = "categoryId") Category category
    ) {

        product.setName(name);
        product.setDescription(description);
        product.setCategories(category);
        product.setPrice(new BigDecimal(price));
        product.setImage(image);

        productService.updateProduct(product);

        return "redirect:/product-manager";
    }


    @PostMapping("/deleteProduct")
    public String updateProduct(
            @RequestParam(name = "id") Product product) {

        productService.deleteProduct(product.getId());

        return "redirect:/product-manager";
    }


}
