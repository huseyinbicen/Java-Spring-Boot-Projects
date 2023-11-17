package com.pexax.springboot_project.repository;

import com.pexax.springboot_project.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long>
{
}
