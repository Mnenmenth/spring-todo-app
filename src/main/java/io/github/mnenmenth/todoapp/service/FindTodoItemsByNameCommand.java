package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;
import io.github.mnenmenth.todoapp.db.TodoRepository;
import io.github.mnenmenth.todoapp.service.exception.TodoItemNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
        List<TodoItem> todoItems = todoRepository.findByName(name);
        if(!todoItems.isEmpty())
        {
            return ResponseEntity.ok(todoItems);
        }
        else
        {
            throw new TodoItemNotFoundException(name);
        }
    }
}
