package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoRepository;
import org.springframework.http.ResponseEntity;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

public class FindAllTodoItemsCommand implements IServiceCommand
{
    private final TodoRepository todoRepository;

    public FindAllTodoItemsCommand(TodoRepository todoRepository)
    {
        this.todoRepository = todoRepository;
    }

    @Override
    public ResponseEntity<Object> execute()
    {
        return ResponseEntity.ok(todoRepository.findAll());
    }
}
