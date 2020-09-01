package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;
import io.github.mnenmenth.todoapp.db.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Creates a new TodoItem in the given TodoRepository and returns the created entity
public class NewTodoItemCommand implements IServiceCommand
{
    private final TodoRepository todoRepository;

    private final String name;
    private final String description;
    public NewTodoItemCommand(TodoRepository todoRepository, String name, String description)
    {
        this.todoRepository = todoRepository;
        this.name = name;
        this.description = description;
    }

    @Override
    public ResponseEntity<Object> execute()
    {
        TodoItem item = todoRepository.save(new TodoItem(name, description, false));
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
