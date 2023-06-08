package phamhieuliem.lab3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phamhieuliem.lab3.entity.Category;
import phamhieuliem.lab3.repository.ICategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category addCategory(Category category) { return categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
