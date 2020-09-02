package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Service to perform operations on TodoItems
public interface TodoItemService
{
    ResponseEntity<Object> createNew(String name, String description);
    ResponseEntity<Object> delete(Integer id);
    ResponseEntity<Object> update(Integer id, Optional<String> name, Optional<String> description, Optional<Boolean> complete);
    ResponseEntity<Object> findById(Integer id);
    ResponseEntity<Object> findByName(String name);
    ResponseEntity<Object> findAll();
}
