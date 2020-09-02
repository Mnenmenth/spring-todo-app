package io.github.mnenmenth.todoapp.controllers;

import io.github.mnenmenth.todoapp.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@RestController
public class FindTodoItemController
{
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping(path = "/todoapp/find/id/{id}")
    public ResponseEntity<Object> findTodoItemById(@PathVariable Integer id)
    {
        return todoItemService.findById(id);
    }

    @GetMapping(path = "/todoapp/find/name/{name}")
    public ResponseEntity<Object> findTodoItemByName(@PathVariable String name)
    {
        return null;
    }

    @GetMapping(path = "/todoapp/find/all")
    public ResponseEntity<Object> findAllTodoItems()
    {
        return null;
    }
}
