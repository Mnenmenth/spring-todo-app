package io.github.mnenmenth.todoapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@SpringBootTest
@AutoConfigureMockMvc
public class DeleteTodoItemControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteTodoItem() throws Exception
    {
        mockMvc.perform(post("/todoapp/new").param("name", "this is a name").param("description", "this is a description")).andDo(print());

        mockMvc.perform(post("/todoapp/delete").param("id", String.valueOf(1))).andDo(print()).andExpect(
                MockMvcResultMatchers.status().is(HttpStatus.NO_CONTENT.value()));
    }

    @Test
    public void deleteInvalidTodoItem() throws Exception
    {
        mockMvc.perform(post("/todoapp/delete").param("id", String.valueOf(1))).andDo(print())
               .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()))
               .andExpect(MockMvcResultMatchers.content().string("No TodoItem entity exists with the given id of '1'"));
    }
}
