package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;
import io.github.mnenmenth.todoapp.db.TodoRepository;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Creates a new TodoItem in the given TodoRepository and returns the created entity
public class NewTodoItemCommand implements IServiceCommand<TodoItem>
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
    public TodoItem execute()
    {
        return todoRepository.save(new TodoItem(name, description, false));
    }
}
