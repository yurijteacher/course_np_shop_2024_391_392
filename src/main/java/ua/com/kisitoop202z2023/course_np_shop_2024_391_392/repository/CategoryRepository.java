package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Page<Category> findAll(Pageable pageable);

}
