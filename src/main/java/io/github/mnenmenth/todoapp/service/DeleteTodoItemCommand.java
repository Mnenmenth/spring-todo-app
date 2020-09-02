package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoRepository;
import io.github.mnenmenth.todoapp.service.exception.TodoItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Attempts to delete a TodoItem in the given TodoItemRepository
public class DeleteTodoItemCommand implements IServiceCommand
{
    private final TodoRepository todoRepository;
    private final Integer id;

    public DeleteTodoItemCommand(TodoRepository todoRepository, Integer id)
    {
        this.todoRepository = todoRepository;
        this.id = id;
    }

    @Override
    public ResponseEntity<Object> execute()
    {
        // If entity exists, delete it and return no content success status
        if(todoRepository.existsById(id))
        {
            todoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        // Otherwise, return a bad request status with error message
        else
        {
            throw new TodoItemNotFoundException(id);
        }
    }
}
