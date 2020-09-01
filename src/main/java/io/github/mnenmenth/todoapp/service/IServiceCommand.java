package io.github.mnenmenth.todoapp.service;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Executable command for a service
public interface IServiceCommand<T>
{
    T execute();
}
