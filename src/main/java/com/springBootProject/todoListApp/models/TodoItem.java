package com.springBootProject.todoListApp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name="ToDo_Item")
public class TodoItem
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String description;
    private boolean complete;
    private Instant createdDate;
    private Instant modifiedDate;

    public TodoItem()
    {

    }

    public TodoItem(String description)
    {
        this.description=description;
        this.complete=false;
        this.createdDate=Instant.now();
        this.modifiedDate=Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString()
    {
        return String.format("TodoItem{id='%d',description='%s',complete='%s',createdDate='%s',modifiedDate='%s'}",id,description,complete,createdDate,modifiedDate);
    }


}
