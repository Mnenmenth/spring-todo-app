package io.github.mnenmenth.todoapp.controllers;

import io.github.mnenmenth.todoapp.service.TodoItemService;
import io.github.mnenmenth.todoapp.db.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@RestController
@RequestMapping("/todoapp/new")
public class NewTodoItemController
{
    @Autowired
    private TodoItemService todoItemService;

    @PostMapping
    public TodoItem newTodoItem(@RequestParam String name, @RequestParam String description)
    {
        return todoItemService.createNew(name, description);
    }
}
