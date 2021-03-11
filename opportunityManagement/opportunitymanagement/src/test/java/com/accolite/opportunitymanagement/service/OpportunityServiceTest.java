package com.accolite.opportunitymanagement.service;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.opportunitymanagement.mapper.OpportunityMapper;
import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.service.Impl.OpportunityServiceImpl;

@SpringBootTest
public class OpportunityServiceTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    OpportunityServiceImpl opportunityServiceImpl;

    @Test
    public void getAllOpportunityTest(){
        ArrayList<Opportunity> opportunityList = new ArrayList<>();
        Opportunity opportunity = createOpportunity();
        opportunityList.add(opportunity);
        Mockito.when(jdbcTemplate.query(
                Mockito.anyString(),
                Mockito.any(OpportunityMapper.class))).thenReturn(opportunityList);
        ArrayList<Opportunity> opportunityResList = (ArrayList<Opportunity>) opportunityServiceImpl.getAllOpportunity();
        Assert.assertEquals(opportunityList.size(),opportunityResList.size());
    }

    @Test
    public void insertOpportunityTest(){
        int expectedVal = 1;
        Opportunity opportunity = createOpportunity();
        Mockito.when(jdbcTemplate.update(
                Mockito.anyString(),
                (Object[])Mockito.any()
        )).thenReturn(expectedVal);
        int resultVal = opportunityServiceImpl.insert(opportunity);
        Assert.assertEquals(expectedVal,resultVal);
    }

    @Test
    public void updateOpportunityTest()
    {
        int expectedVal = 1;
        int id = 1;
        Opportunity opportunity = createOpportunity();
        Mockito.when(jdbcTemplate.update(
                Mockito.anyString(),
                (Object[])Mockito.any()
        )).thenReturn(expectedVal);
        int resultVal = opportunityServiceImpl.update(opportunity,id);
        Assert.assertEquals(expectedVal,resultVal);
    }

    @Test
    public void deleteOpportunityTest()
    {
        int expectedVal = 1;
        int id = 1;
        Mockito.when(jdbcTemplate.update(
                Mockito.anyString(),
                (Object[])Mockito.any()
        )).thenReturn(expectedVal);
        int resultVal = opportunityServiceImpl.delete(id);
        Assert.assertEquals(expectedVal,resultVal);
    }

    private Opportunity createOpportunity()
    {
        Opportunity opportunity = new Opportunity();
        opportunity.setId(1);
        opportunity.setDescription("Java Developer");
        opportunity.setLocation("Mumbai");
        opportunity.setSkills("Spring Boot");
        opportunity.setEmail("accolite.digital@accolite.digital.com");
        opportunity.setMinExperience(2);
        opportunity.setDemand(4);
        opportunity.setDate(new Date(System.currentTimeMillis()));
        return opportunity;
    }

}