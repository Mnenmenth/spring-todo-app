package io.github.mnenmenth.todoapp.service.exception;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

public class TodoItemNotFoundException extends RuntimeException
{
    public TodoItemNotFoundException(Integer id)
    {
        super("No TodoItem entity exists with the given id of '" + id + "'");
    }

    public TodoItemNotFoundException(String name)
    {
        super("No TodoItem entity exists with the given name of '" + name + "'");
    }
}
