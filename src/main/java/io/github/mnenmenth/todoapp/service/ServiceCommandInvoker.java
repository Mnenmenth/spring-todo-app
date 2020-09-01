package io.github.mnenmenth.todoapp.service;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

// Invokes a given service command
public class ServiceCommandInvoker
{
    public<T> T invoke(IServiceCommand<T> command)
    {
        return command.execute();
    }
}
