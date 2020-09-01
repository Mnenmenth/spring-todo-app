package io.github.mnenmenth.todoapp.service;

import org.springframework.http.ResponseEntity;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Invokes a given service command
public class ServiceCommandInvoker
{
    public ResponseEntity<Object> invoke(IServiceCommand command)
    {
        return command.execute();
    }
}
