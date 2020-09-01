package io.github.mnenmenth.todoapp.db;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@SpringBootTest
public class TodoRepositoryTest
{

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void findByNameTest()
    {
        final String name = "Todo Name";
        TodoItem item = new TodoItem();
        item.setName(name);
        todoRepository.save(item);
        assertFalse(todoRepository.findByName(name).isEmpty());
    }
}
