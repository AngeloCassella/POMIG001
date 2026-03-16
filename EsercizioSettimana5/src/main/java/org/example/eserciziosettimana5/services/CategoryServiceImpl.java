package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.Category;
import org.example.eserciziosettimana5.repositories.CategoryRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired @Qualifier("createcategory") ObjectProvider<Category> createCategoryObjectProvider;
    @Autowired @Qualifier("createfakecategory") ObjectProvider<Category> createFakeCategoryObjectProvider;
    @Autowired CategoryRepository categoryRepo;

    public Category createCategory(String nome) {
        Category category = createCategoryObjectProvider.getObject();
        category.setNome(nome);
        return category;
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepo.save(category);
        System.out.println("Category saved: " + category.getNome());
    }

    @Override
    public Category findCategory(long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepo.delete(category);
        System.out.println("Category deleted: " + category.getNome());
    }

    public Category createFakeCategory() {
        return createFakeCategoryObjectProvider.getObject();
    }


}
