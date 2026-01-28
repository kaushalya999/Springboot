package ijse.springIntroNew.service;

import java.util.List;
import ijse.springIntroNew.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ijse.springIntroNew.repositoty.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoriesList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category CreateCategory(Category category) {
        return categoryRepository.save(category);
    }

}
