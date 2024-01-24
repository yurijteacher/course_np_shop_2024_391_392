package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Category;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategories(Category category);

    // пошук по словам
    List<Product> findAllByNameOrderByName(String name);

    // пошук по буквам!!!
    List<Product> findAllByNameContainsIgnoreCaseOrderByName(String name);
}
