package io.github.mnenmenth.todoapp.controllers;

import io.github.mnenmenth.todoapp.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@RestController
@RequestMapping("/todoapp/update/{id}")
public class UpdateTodoItemController
{
    @Autowired
    private TodoItemService todoItemService;

    @PatchMapping
    public ResponseEntity<Object> updateTodoItem(
            @PathVariable Integer id,
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> description,
            @RequestParam Optional<Boolean> complete
            )
    {
        return todoItemService.update(id, name, description, complete);
    }
}
