package ijse.springIntroNew.service;

import java.util.List;
import ijse.springIntroNew.entity.Category;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    List<Category> getCategoriesList(); // Reading

    Category CreateCategory(Category category); // Creating

    Category getCategoryById(Long id);

}
