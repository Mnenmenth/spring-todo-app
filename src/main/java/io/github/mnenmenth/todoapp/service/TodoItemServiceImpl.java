package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;
import io.github.mnenmenth.todoapp.db.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> createNew(String name, String description)
    {
        return invoker.invoke(new NewTodoItemCommand(todoRepository, name, description));
    }

    @Override
    public ResponseEntity<Object> delete(Integer id)
    {
        return null;
    }

    @Override
    public ResponseEntity<Object> findById(Integer id)
    {
        return null;
    }

    @Override
    public ResponseEntity<Object> findByName(String name)
    {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAll()
    {
        return null;
    }
}
