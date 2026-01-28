package ijse.springIntroNew.controller;

import java.util.List;
import ijse.springIntroNew.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ijse.springIntroNew.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {

        List<Category> categoryList = categoryService.getCategoriesList();
        return ResponseEntity.status(200).body(categoryList);
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category categories = categoryService.CreateCategory(category);
        return ResponseEntity.status(201).body(categories);
    }

}
