package com.pexax.springboot_project.service;

import com.pexax.springboot_project.entity.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeServices
{
    Optional<Recipe> getRecipes(Long id);
}
