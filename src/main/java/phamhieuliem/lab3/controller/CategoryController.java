package phamhieuliem.lab3.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import phamhieuliem.lab3.entity.Category;
import phamhieuliem.lab3.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllCategories(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "category/list";

    }

    @GetMapping("/add")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/add";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long categoryId, Model model) {
        Category category = categoryService.getCategoryById(categoryId);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long categoryId,
                               @Valid @ModelAttribute("category") Category updatedCategory,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/edit";
        }

        Category category = categoryService.getCategoryById(categoryId);
        category.setName(updatedCategory.getName());
        // Update other properties of the category if necessary

        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/categories";
    }
}
