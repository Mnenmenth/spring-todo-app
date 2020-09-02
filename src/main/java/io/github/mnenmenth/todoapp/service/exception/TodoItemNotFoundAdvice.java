package io.github.mnenmenth.todoapp.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@ControllerAdvice
public class TodoItemNotFoundAdvice
{
    @ResponseBody
    @ExceptionHandler(TodoItemNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public String todoItemNotFoundHandler(TodoItemNotFoundException ex)
    {
        return ex.getMessage();
    }
}
