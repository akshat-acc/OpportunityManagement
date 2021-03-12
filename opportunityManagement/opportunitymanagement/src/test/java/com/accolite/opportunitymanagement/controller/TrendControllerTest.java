package com.accolite.opportunitymanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.service.Impl.TrendServiceImpl;

@WebMvcTest(controllers = TrendController.class)
public class TrendControllerTest {
	
	@Autowired
    public MockMvc mockMvc;

    @MockBean
    public TrendServiceImpl trendServiceImpl;

    @Mock
    public DataSource datasource;
    
    @Mock
    public JdbcTemplate jdbcTemplate;
    

    @Test
    public void getLocationTest() throws Exception{
//        ArrayList<String> locationList=new ArrayList<String>();
		List<String> LocationList = new ArrayList<String>();
		String query = "select distinct location from Opportunity";
		List<Map<String,Object>> mockRows=new ArrayList<>();
		HashMap<String,Object> param=new HashMap<String,Object>();
		param.put("location",new Opportunity(1,"Java Developer","Mumbai","SpringBoot","accolite.digital@accolite.digital.com",3,5,new Date(System.currentTimeMillis())));
		mockRows.add(param);
		Mockito.when(jdbcTemplate.queryForList(query)).thenReturn(mockRows);
        mockMvc.perform(get("/trends/getLocation")).andExpect(status().isOk());
    }
    
    @Test
    public void getLocationCountTest() throws Exception{
    List<Long> locList = new ArrayList<>();
    locList.add(2L);
    locList.add(3L);
    Mockito.when(trendServiceImpl.getByLocationCount()).thenReturn(locList);
    mockMvc.perform(get("/trends/getLocationCount")).andExpect(status().isOk());
    }
    
    @Test
    public void getSkillTest()throws Exception{
    List<String> skillList = new ArrayList<>();
    skillList.add("java");
    skillList.add("python");
    Mockito.when(trendServiceImpl.getBySkill()).thenReturn(skillList);
    mockMvc.perform(get("/trends/getSkills")).andExpect(status().isOk());
    }
    @Test
    public void getSkillCountTest() throws Exception{
    List<Integer> locList = new ArrayList<>();
    locList.add(2);
    locList.add(3);
    Mockito.when(trendServiceImpl.getBySkillCount()).thenReturn(locList);
    mockMvc.perform(get("/trends/getSkillsCount")).andExpect(status().isOk());
    }

    @Test
    public void getYearTest()throws Exception{
    List<String> yearList = new ArrayList<>();
    yearList.add("2021");
    yearList.add("2022");
    Mockito.when(trendServiceImpl.getByYoY()).thenReturn(yearList);
    mockMvc.perform(get("/trends/getYoY")).andExpect(status().isOk());
    }

    @Test
    public void getYearCountTest() throws Exception{
    List<Integer> locList = new ArrayList<>();
    locList.add(2);
    locList.add(3);
    Mockito.when(trendServiceImpl.getByYoYCount()).thenReturn(locList);
    mockMvc.perform(get("/trends/getYoYCount")).andExpect(status().isOk());
    }
    @Test
    public void getYearByLocationTest()throws Exception{
    String location="mumbai";
    List<String> locationList = new ArrayList<>();
    locationList.add("mumbai");
    locationList.add("delhi");
    Mockito.when(trendServiceImpl.getByYoY(location)).thenReturn(locationList);
    mockMvc.perform(get("/trends/getYoY/".concat((location)))).andExpect(status().isOk());
    }

    @Test
    public void getYearByLocationCountTest() throws Exception{
    List<Integer> locList = new ArrayList<>();
    String location = "mumbai";
    locList.add(2);
    locList.add(3);
    Mockito.when(trendServiceImpl.getByYoYCount()).thenReturn(locList);
    mockMvc.perform(get("/trends/getYoYCount/".concat((location)))).andExpect(status().isOk());
    }


}
