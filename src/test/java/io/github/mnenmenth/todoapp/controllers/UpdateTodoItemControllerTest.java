package io.github.mnenmenth.todoapp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Earl Kennedy
 * https://github.com/Mnenmenth
 */

@SpringBootTest
@AutoConfigureMockMvc
public class UpdateTodoItemControllerTest
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
    public void updateTodoItemAll() throws Exception
    {

        mockMvc.perform(put("/todoapp/update/1").param("name", "a").param("description", "b").param("complete", "true"))
               .andDo(print())
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"a\",\"description\":\"b\",\"complete\":true}"));
    }

    @Test
    public void updateTodoItemName() throws Exception
    {
        mockMvc.perform(put("/todoapp/update/1").param("name", "a"))
               .andDo(print())
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"a\",\"description\":\"this is a description\",\"complete\":false}"));
    }

    @Test
    public void updateTodoItemDesc() throws Exception
    {
        mockMvc.perform(put("/todoapp/update/1").param("description", "b"))
               .andDo(print())
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"this is a name\",\"description\":\"b\",\"complete\":false}"));
    }

    @Test
    public void updateTodoItemComplete() throws Exception
    {
        mockMvc.perform(put("/todoapp/update/1").param("complete", "true"))
               .andDo(print())
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"this is a name\",\"description\":\"this is a description\",\"complete\":true}"));
    }
    
    @Test
    public void updateInvalidTodoItem() throws Exception
    {
        mockMvc.perform(put("/todoapp/update/5").param("complete", "true"))
               .andDo(print())
               .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
               .andExpect(MockMvcResultMatchers.content().string("No TodoItem entity exists with the given id of '5'"));
    }
}
