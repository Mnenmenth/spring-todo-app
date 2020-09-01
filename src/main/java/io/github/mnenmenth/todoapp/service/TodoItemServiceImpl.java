package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;
import io.github.mnenmenth.todoapp.db.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@Service
public class TodoItemServiceImpl implements TodoItemService
{
    @Autowired
    private TodoRepository todoRepository;
    private ServiceCommandInvoker invoker;
    public TodoItemServiceImpl()
    {
        this.invoker = new ServiceCommandInvoker();
    }

    @Override
    public TodoItem createNew(String name, String description)
    {
        return invoker.invoke(new NewTodoItemCommand(todoRepository, name, description));
    }

    @Override
    public TodoItem delete(Integer id)
    {
        return null;
    }

    @Override
    public TodoItem findById(Integer id)
    {
        return null;
    }

    @Override
    public Collection<TodoItem> findByName(String name)
    {
        return null;
    }

    @Override
    public Collection<TodoItem> findAll()
    {
        return null;
    }
}
