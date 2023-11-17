package com.pexax.springboot_project.service;

import com.pexax.springboot_project.entity.Recipe;
import com.pexax.springboot_project.repository.RecipeRepository;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeSeeviceImpl implements RecipeServices
{
    private final  RecipeRepository recipeRepository;

    @Autowired
    public RecipeSeeviceImpl(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Optional<Recipe> getRecipes(Long id)
    {
        Optional<Recipe> recipe = recipeRepository.findById(1L);
        return recipe;
    }
}
