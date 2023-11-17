package com.pexax.springboot_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Notes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    private Recipe recipe;

    @Lob
    private String recepeNotes;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

    public String getRecepeNotes()
    {
        return recepeNotes;
    }

    public void setRecepeNotes(String recepeNotes)
    {
        this.recepeNotes = recepeNotes;
    }
}
