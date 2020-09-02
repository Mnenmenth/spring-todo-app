package io.github.mnenmenth.todoapp.service;

import io.github.mnenmenth.todoapp.db.TodoItem;
import io.github.mnenmenth.todoapp.db.TodoRepository;
import io.github.mnenmenth.todoapp.service.exception.TodoItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Attempts to update a TodoItem in the given TodoItemRepository
// A field is only updated if the value is present in the Optional<>
public class UpdateTodoItemCommand implements IServiceCommand
{
    private final TodoRepository todoRepository;

    private final Integer id;
    private final Optional<String> name;
    private final Optional<String> description;
    private final Optional<Boolean> complete;

    public UpdateTodoItemCommand(TodoRepository todoRepository,
                                 Integer id,
                                 Optional<String> name,
                                 Optional<String> description,
                                 Optional<Boolean> complete
                                )
    {
        this.todoRepository = todoRepository;
        this.id = id;
        this.name = name;
        this.description = description;
        this.complete = complete;
    }

    @Override
    public ResponseEntity<Object> execute()
    {
        Optional<TodoItem> entity = todoRepository.findById(id);

        // If entity exists, update relevant fields
        // and return success status with updated entity
        if(entity.isPresent())
        {
            TodoItem item = entity.get();
            name.ifPresent(item::setName);
            description.ifPresent(item::setDescription);
            complete.ifPresent(item::setComplete);
            return ResponseEntity.ok(item);
        }
        // Otherwise, return a bad request status with error message
        else
        {
            throw new TodoItemNotFoundException(id);
        }
    }
}
