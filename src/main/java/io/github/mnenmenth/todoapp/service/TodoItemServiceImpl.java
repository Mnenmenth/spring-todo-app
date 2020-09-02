package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;
import io.github.mnenmenth.todoapp.db.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
        return invoker.invoke(new DeleteTodoItemCommand(todoRepository, id));
    }

    @Override
    public ResponseEntity<Object> update(Integer id,
                                         Optional<String> name,
                                         Optional<String> description,
                                         Optional<Boolean> complete
                                        )
    {
        return invoker.invoke(new UpdateTodoItemCommand(todoRepository, id, name, description, complete));
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
