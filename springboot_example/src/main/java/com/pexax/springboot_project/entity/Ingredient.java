package com.pexax.springboot_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String description;
    private BigDecimal amount;

    @JsonBackReference
    @OneToOne()
    private UnitOfMeasure uom;

    @ManyToOne
    @JsonBackReference
    private Recipe recipe;

    public Ingredient()
    {

    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom,Recipe guacRecipe)
    {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipe = guacRecipe;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }
}
