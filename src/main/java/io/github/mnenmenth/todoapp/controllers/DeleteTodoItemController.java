package io.github.mnenmenth.todoapp.controllers;

import io.github.mnenmenth.todoapp.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@RestController
@RequestMapping("/todoapp/delete")
public class DeleteTodoItemController
{
    @Autowired
    private TodoItemService todoItemService;

    @PostMapping
    public ResponseEntity<Object> deleteTodoItem(@Validated @RequestParam Integer id)
    {
        return todoItemService.delete(id);
    }
}
