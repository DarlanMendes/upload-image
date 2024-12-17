package br.menu.menu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.menu.menu.model.Category;
import br.menu.menu.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category create(Category category, MultipartFile file){
        
        
        category.setUrlImage("....");
        return categoryRepository.save(category);
    }
}
