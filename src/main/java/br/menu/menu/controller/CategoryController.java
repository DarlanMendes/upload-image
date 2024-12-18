package br.menu.menu.controller;



import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.multipart.MultipartFile;

import br.menu.menu.dto.req.CategoryReqDTO;
import br.menu.menu.model.Category;
import br.menu.menu.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Category> getMethodName(@PathVariable("id") String id) throws Exception{
        return ResponseEntity.ok(categoryService.findById(id));
    }
    
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> createCatergory(@RequestPart(value = "file") MultipartFile file, @RequestPart(value = "category") @Valid CategoryReqDTO category ){
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        return ResponseEntity.ok(categoryService.create(newCategory, file));
    }
    
}
