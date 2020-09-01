package io.github.mnenmenth.todoapp.db;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

public interface TodoRepository extends CrudRepository<TodoItem, Integer>
{
    List<TodoItem> findByName(String name);
}
