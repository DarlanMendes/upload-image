package br.menu.menu.controller;



import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.multipart.MultipartFile;

import br.menu.menu.dto.req.CategoryReqDTO;
import br.menu.menu.model.Category;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> createCatergory(@RequestPart(value = "file") MultipartFile file, @RequestPart(value = "category") @Valid CategoryReqDTO category ){
        Category ncategory = new Category();
        System.out.println(category.getName());
        return ResponseEntity.ok(ncategory);
    }
    
}
