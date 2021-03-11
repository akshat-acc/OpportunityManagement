package com.accolite.opportunitymanagement.controller;

import java.sql.Date;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.service.Impl.OpportunityServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = OpportunityController.class)
public class OpportunityControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public OpportunityServiceImpl opportunityServiceImpl;

    @Autowired
    public ObjectMapper objectMapper;

    @Before
    private Opportunity createOpportunity()
    {
        Opportunity opportunity = new Opportunity(1,"Java Developer","Mumbai","SpringBoot","accolite.digital@accolite.digital.com",3,5,new Date(System.currentTimeMillis()));
        return opportunity;
    }

    @Test
    public void getAllControllerTest() throws Exception{
        ArrayList<Opportunity> opportunityArrayList = new ArrayList<>();
        Opportunity opportunity = createOpportunity();
        opportunityArrayList.add(opportunity);
        Mockito.when(opportunityServiceImpl.getAllOpportunity()).thenReturn(opportunityArrayList);
        mockMvc.perform(get("/opportunity/getAll")).andExpect(status().isOk());
    }

    @Test
    public void addTest() throws Exception{
        Opportunity opportunity = createOpportunity();
        String jsonString = objectMapper.writeValueAsString(opportunity);
        Mockito.when(opportunityServiceImpl.insert(opportunity)).thenReturn(1);
        mockMvc.perform(post("/opportunity/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonString).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }

    @Test
    public void updateTest() throws Exception{
        Opportunity opportunity = createOpportunity();
        String jsonString = objectMapper.writeValueAsString(opportunity);
        Mockito.when(opportunityServiceImpl.insert(opportunity)).thenReturn(1);
        mockMvc.perform(post("/opportunity/update/1").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonString).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception{
        int id = 1;
        Mockito.when(opportunityServiceImpl.delete(id)).thenReturn(1);
        mockMvc.perform(delete("/opportunity/delete/".concat(String.valueOf(id))).contentType(MediaType.APPLICATION_JSON_VALUE).content(String.valueOf(id)).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }
}