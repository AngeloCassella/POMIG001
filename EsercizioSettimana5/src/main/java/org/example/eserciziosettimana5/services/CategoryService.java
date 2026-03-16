package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(String nome);
    public Category createFakeCategory();
    public void saveCategory(Category category);
    public Category findCategory(long id);
    public List<Category> findAll();
    public void deleteCategory(Category category);

}
