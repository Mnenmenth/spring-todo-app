package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;
import io.github.mnenmenth.todoapp.db.TodoRepository;
import io.github.mnenmenth.todoapp.service.exception.TodoItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

public class FindTodoItemByIdCommand implements IServiceCommand
{
    private final TodoRepository todoRepository;
    private final Integer id;

    public FindTodoItemByIdCommand(TodoRepository todoRepository, Integer id)
    {
        this.todoRepository = todoRepository;
        this.id = id;
    }

    @Override
    public ResponseEntity<Object> execute()
    {
        Optional<TodoItem> entity = todoRepository.findById(id);
        if(entity.isPresent())
        {
            return ResponseEntity.ok(entity.get());
        }
        else
        {
            throw new TodoItemNotFoundException(id);
        }
    }
}
