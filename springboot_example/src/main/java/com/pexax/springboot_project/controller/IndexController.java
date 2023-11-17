package com.pexax.springboot_project.controller;

import com.pexax.springboot_project.entity.Recipe;
import com.pexax.springboot_project.service.RecipeServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class IndexController {

   private final RecipeServices recipeServices;

    public IndexController(RecipeServices recipeServices)
    {
        this.recipeServices = recipeServices;
    }

    @GetMapping("/index")
    public Optional<Recipe> getIndexPage()
    {
        return recipeServices.getRecipes(2L);
    }
}
