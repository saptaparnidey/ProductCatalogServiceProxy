package org.example.productcatalogserviceproxy.controller;

import org.example.productcatalogserviceproxy.dto.CategoryDTO;
import org.example.productcatalogserviceproxy.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    private String getCategories(){
        return "Returning list of all categories";
    }

    @GetMapping("{id}")
    private String getCategory(@PathVariable Long id){
        return "Returning category with id : " + id;
    }

    @PostMapping
    private String createCategory(@RequestBody CategoryDTO categoryDTO){
        return "Creating Category -- " + categoryDTO;
    }

    @PatchMapping
    private String updateCategory(@RequestBody CategoryDTO categoryDTO){
        return "Updating Category -- " + categoryDTO;
    }

    @DeleteMapping("{id}")
    private String deleteCategory(@PathVariable Long id){
        return "Category deleted with id " + id;
    }
}
