package com.springBootProject.todoListApp.config;

import com.springBootProject.todoListApp.models.TodoItem;
import com.springBootProject.todoListApp.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner
{
    private final Logger logger= LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception
    {
        loadSeedData();
    }

    private void loadSeedData()
    {
        if(todoItemRepository.count()==0)
        {
            TodoItem todoItem1=new TodoItem("get the milk");
            TodoItem todoItem2=new TodoItem("rake the leaves");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }
        logger.info("Number of Todo items:{}",todoItemRepository.count());
    }
}
