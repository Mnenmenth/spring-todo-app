package io.github.mnenmenth.todoapp.service;

import org.springframework.http.ResponseEntity;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Executable command for a service
public interface IServiceCommand
{
    ResponseEntity<Object> execute();
}
