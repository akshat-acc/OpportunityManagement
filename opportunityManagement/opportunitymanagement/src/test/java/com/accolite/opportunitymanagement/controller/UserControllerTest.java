package com.accolite.opportunitymanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.opportunitymanagement.model.User;
import com.accolite.opportunitymanagement.service.Impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public UserServiceImpl userServiceImpl;

    @Autowired
    public ObjectMapper objectMapper;

    @Before
    private User createUser()
    {
        User user = new User();
        user.setUserId(1);
        user.setFirstName("Accolite");
        user.setLastName("Digital");
        user.setEmail("accolite@accolite.digital.com");
        return user;
    }

    @Test
    public void getAllUserTest() throws Exception{
        ArrayList<User> userList = new ArrayList<>();
        User user = createUser();
        userList.add(user);
        Mockito.when(userServiceImpl.getAllUser()).thenReturn(userList);
        mockMvc.perform(get("/user/getAllUser")).andExpect(status().isOk());
    }

    @Test
    public void insertTest() throws Exception{
        User user = createUser();
        String jsonString = objectMapper.writeValueAsString(user);
        Mockito.when(userServiceImpl.insert(user)).thenReturn(1);
        mockMvc.perform(post("/user/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonString).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }
}
