package com.springBootProject.todoListApp.controllers;

import com.springBootProject.todoListApp.models.TodoItem;
import com.springBootProject.todoListApp.repositories.TodoItemRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;

@Controller
public class TodoFormController
{
    private final Logger logger= LoggerFactory.getLogger(TodoFormController.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model)
    {
        TodoItem todoItem=todoItemRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Todo Item id:"+id+" not found"));
        model.addAttribute("todo",todoItem);
        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id,Model model)
    {
        TodoItem todoItem=todoItemRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Todo Item id:"+id+" not found"));
        todoItemRepository.delete(todoItem);
        return "redirect:/";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result,Model model)
    {
        if(result.hasErrors())
        {
            return "add-todo-item";
        }
        todoItem.setCreatedDate(Instant.now());
        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem)
    {
        return "add-todo-item";
    }
}
