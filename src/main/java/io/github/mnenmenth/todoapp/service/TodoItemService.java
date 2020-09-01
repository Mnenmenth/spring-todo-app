package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;

import java.util.Collection;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Service to perform operations on TodoItems
public interface TodoItemService
{
    TodoItem createNew(String name, String description);
    TodoItem delete(Integer id);
    TodoItem findById(Integer id);
    Collection<TodoItem> findByName(String name);
    Collection<TodoItem> findAll();
}
