package com.accolite.opportunitymanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.opportunitymanagement.model.Audit;
import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.service.Impl.AuditServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = AuditController.class)
public class AuditControllerTest {
	
    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public AuditServiceImpl auditServiceImpl;

    @Autowired
    public ObjectMapper objectMapper;

    @Before
    private Audit createAudit()
    {
    	Audit audit = new Audit();
    	audit.setId(1);
    	audit.setManagerEmail("accolite.digital@accolitedigital.com");
    	audit.setDate(new Date(System.currentTimeMillis()));
    	audit.setOperation("Create");
    	audit.setOldData("'{}'");
    	audit.setNewData("'{\\\"oppid\\\":\\\"0\\\",\\\"description\\\":\\\"Data Engineer\\\",\\\"location\\\":\\\"Hyderabad\\\",\\\"date\\\":\\\"2021-03-27T00:00:00.000Z\\\",\\\"skills\\\":\\\"Python,Nlp\\\",\\\"demand\\\":5,\\\"minExperience\\\":3,\\\"email\\\":\\\"akshat.mehta@accolitedigital.com\\\"}'");
        return audit;
    }
    
    @Test
    public void getAllControllerTest() throws Exception{
        ArrayList<Audit> auditArrayList = new ArrayList<>();
        Audit audit = createAudit();
        auditArrayList.add(audit);
        Mockito.when(auditServiceImpl.getAllAudit()).thenReturn(auditArrayList);
        mockMvc.perform(get("/audit/getAllAudit")).andExpect(status().isOk());
    }

    @Test
    public void addTest() throws Exception{
        Audit audit = createAudit();
        String jsonString = objectMapper.writeValueAsString(audit);
        Mockito.when(auditServiceImpl.insert(audit)).thenReturn(1);
        mockMvc.perform(post("/audit/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonString).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }
}

