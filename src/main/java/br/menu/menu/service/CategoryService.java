package br.menu.menu.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.menu.menu.model.Category;
import br.menu.menu.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CloudinaryServiceImpl cloudinaryServiceImpl;

    public Category create(Category category, MultipartFile file) {

        String imgURL = cloudinaryServiceImpl.uploadFile(file, "category");
        System.out.println(imgURL);
        category.setUrlImage(imgURL);
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(String id) throws BadRequestException {
        try {
            UUID formattedId = UUID.fromString(id);
            return categoryRepository.findById(formattedId)
                    .orElseThrow(() -> new EntityNotFoundException("Category not found, id: " + id));
        } catch (IllegalArgumentException e) {

            throw new BadRequestException("Invalid UUID format: " + id, e);
        } catch (EntityNotFoundException e) {

            throw e;
        } catch (Exception e) {

            throw new RuntimeException("An unexpected error occurred while retrieving the category.", e);
        }

    }
}
