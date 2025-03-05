package com.springBootProject.todoListApp.repositories;

import com.springBootProject.todoListApp.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem,Long> {
}
