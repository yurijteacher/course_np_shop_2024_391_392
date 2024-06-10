package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Category;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){

//        List<Category> categories = new ArrayList<>();
//        categories = categoryRepository.findAll();  // select * from table
//        return categories;

        return categoryRepository.findAll();
    }


    @Cacheable(value = "pageCategory")
    public Page<Category> getPageElCategory(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }


    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }




}
