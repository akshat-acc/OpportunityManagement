package com.accolite.opportunitymanagement.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.opportunitymanagement.controller.TrendController;
import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.service.Impl.TrendServiceImpl;

//@WebMvcTest(service = TrendController.class)
@SpringBootTest
public class TrendServiceImplTest {
	
	@Autowired
    public MockMvc mockMvc;

    @InjectMocks
    public TrendServiceImpl trendServiceImpl;

    @Mock
    public DataSource datasource;
    
    @Mock
    public JdbcTemplate jdbcTemplate;
    
//    @Test
//    public void getLocationTest() {
//    	jdbcTemplate=new JdbcTemplate(new DataSource());
//    	List<String> LocationList = new ArrayList<String>();
//    	LocationList.add("Mumbai");
//    	List<Map<String,Object>> mockRows=new ArrayList<>();
//		HashMap<String,Object> param=new HashMap<String,Object>();
//		param.put("location",new Opportunity(1,"Java Developer","Mumbai","SpringBoot","accolite.digital@accolite.digital.com",3,5,new Date(System.currentTimeMillis())));
//		mockRows.add(param);
//    	Mockito.when(jdbcTemplate.queryForList(Mockito.anyString())).thenReturn(mockRows);
//    	trendServiceImpl.getByLocation();
//    }
}
