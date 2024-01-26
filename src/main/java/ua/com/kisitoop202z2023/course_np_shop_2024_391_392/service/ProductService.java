package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Category;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Product;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findProductsByCategory(Category category){
        return productRepository.findAllByCategories(category);
    }

    public Page<Product> getPageProductsByCategory(Pageable pageable, Category category){
        return productRepository.findAllByCategories(pageable, category);
    }



}
