package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoRepository;
import org.springframework.http.ResponseEntity;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

public class FindTodoItemsByNameCommand implements IServiceCommand
{
    private final TodoRepository todoRepository;
    private final String name;

    public FindTodoItemsByNameCommand(TodoRepository todoRepository, String name)
    {
        this.todoRepository = todoRepository;
        this.name = name;
    }

    @Override
    public ResponseEntity<Object> execute()
    {
        return ResponseEntity.ok(todoRepository.findByName(name));
    }
}
