package io.github.mnenmenth.todoapp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@SpringBootTest
@AutoConfigureMockMvc
public class FindTodoItemControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void createTodoItem() throws Exception
    {
        mockMvc.perform(post("/todoapp/new").param("name", "this is a name").param("description", "this is a description"))
               .andDo(print());
    }

    @Test
    public void findById() throws Exception
    {
        mockMvc.perform(get("/todoapp/find/id/1"))
               .andDo(print())
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"this is a name\",\"description\":\"this is a description\",\"complete\":false}"));
    }

    @Test
    public void findByInvalidId() throws Exception
    {
        mockMvc.perform(get("/todoapp/find/id/5"))
               .andDo(print())
               .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
               .andExpect(MockMvcResultMatchers.content().string("No TodoItem entity exists with the given id of '5'"));
    }
}
