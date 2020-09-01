package io.github.mnenmenth.todoapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class NewTodoItemControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void newTodoItem() throws Exception
    {
        this.mockMvc.perform(post("/todoapp/new").param("name", "this is a name").param("description", "this is a description")).andDo(print()).andExpect(
                MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"this is a name\",\"description\":\"this is a description\",\"complete\":false}"));

    }
}
