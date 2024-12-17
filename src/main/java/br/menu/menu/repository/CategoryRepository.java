package br.menu.menu.repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;

import br.menu.menu.model.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID>{
    
}
