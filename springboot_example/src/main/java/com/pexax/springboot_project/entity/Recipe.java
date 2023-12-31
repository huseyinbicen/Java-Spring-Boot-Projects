package com.pexax.springboot_project.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer cooktime;
    private Integer preptime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String direction;

    @Lob
    private Byte[] image;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany()
    @JsonManagedReference
    @JoinTable(name = "recipe_category" ,
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn( name = "category_id"))
    private Set<Category> categories;

    public String getDescription()
    {
        return description;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getCooktime()
    {
        return cooktime;
    }

    public void setCooktime(Integer cooktime)
    {
        this.cooktime = cooktime;
    }

    public Integer getPreptime()
    {
        return preptime;
    }

    public void setPreptime(Integer preptime)
    {
        this.preptime = preptime;
    }

    public Integer getServings()
    {
        return servings;
    }

    public void setServings(Integer servings)
    {
        this.servings = servings;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getDirection()
    {
        return direction;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public Byte[] getImage()
    {
        return image;
    }

    public void setImage(Byte[] image)
    {
        this.image = image;
    }

    public Notes getNotes()
    {
        return notes;
    }

    public void setNotes(Notes notes)
    {
        this.notes = notes;
    }

    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    public Set<Ingredient> getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients)
    {
        this.ingredients = ingredients;
    }

    public Set<Category> getCategories()
    {
        return categories;
    }

    public void setCategories(Set<Category> categories)
    {
        this.categories = categories;
    }
}
