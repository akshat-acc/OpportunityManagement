package com.accolite.opportunitymanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.opportunitymanagement.service.Impl.TrendServiceImpl;

//@WebMvcTest(controllers = TrendController.class)
@SpringBootTest
public class TrendServiceImplTest {
	
//	@Autowired
//    public MockMvc mockMvc;

    @InjectMocks
    public TrendServiceImpl trendServiceImpl;

    @Mock
    public DataSource datasource;
    
    @Mock
    public JdbcTemplate jdbcTemplate;
    
//    @Test
//    public void getLocationTest() {
//    	jdbcTemplate=new JdbcTemplate(datasource);
//    	List<String> LocationList = new ArrayList<String>();
//    	LocationList.add("Mumbai");
//    	List<Map<String,Object>> mockRows=new ArrayList<Map<String, Object>>();
//		Map<String,Object> param=new HashMap<String,Object>();
//		param.put("location","Mumbai");
//		mockRows.add(param);
//    	Mockito.when(jdbcTemplate.queryForList("select distinct location from Opportunity")).thenReturn(mockRows);
//    	List<String> resList=trendServiceImpl.getByLocation();
//    	Assert.assertEquals(LocationList.size(), resList.size());
//    }
}
