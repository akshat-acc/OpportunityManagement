package com.accolite.opportunitymanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.opportunitymanagement.service.Impl.TrendServiceImpl;

//@WebMvcTest(controllers = TrendController.class)
@SpringBootTest
public class TrendServiceImplTest {

    @InjectMocks
    public TrendServiceImpl trendServiceImpl;

    @Mock
    public JdbcTemplate jdbcTemplate;
    
    @Test
    public void getLocationTest() {
    	List<String> LocationList = new ArrayList<String>();
    	LocationList.add("Mumbai");
    	List<Map<String,Object>> mockRows=new ArrayList<Map<String, Object>>();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("location","Mumbai");
		mockRows.add(param);
    	Mockito.when(jdbcTemplate.queryForList(Mockito.anyString())).thenReturn(mockRows);
    	List<String> resList=trendServiceImpl.getByLocation();
    	Assert.assertEquals(LocationList.size(), resList.size());
    }
    
    @Test
    public void getLocationCountTest() {
    	List<Long> LocationCountList = new ArrayList<Long>();
    	LocationCountList.add(1L);
    	List<Map<String,Object>> mockRows=new ArrayList<Map<String, Object>>();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("count(*)",1L);
		mockRows.add(param);
    	Mockito.when(jdbcTemplate.queryForList(Mockito.anyString())).thenReturn(mockRows);
    	List<Long> resCountList=trendServiceImpl.getByLocationCount();
    	Assert.assertEquals(LocationCountList, resCountList);
    }
    
    @Test
    public void getSkillTest() {
    	List<String> skillList = new ArrayList<String>();
    	skillList.add("Spring");
    	List<Map<String,Object>> mockRows=new ArrayList<Map<String, Object>>();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("skills","Spring");
		mockRows.add(param);
		Map<String,Object> param1=new HashMap<String,Object>();
		param1.put("skills","Spring");
		mockRows.add(param1);
    	Mockito.when(jdbcTemplate.queryForList(Mockito.anyString())).thenReturn(mockRows);
    	List<String> resSkillList=trendServiceImpl.getBySkill();
    	Assert.assertEquals(skillList, resSkillList);
    }
    
    @Test
    public void getSkillCountTest() {
    	List<Integer> skillCountList = new ArrayList<Integer>();
    	skillCountList.add(2);
    	List<Map<String,Object>> mockRows=new ArrayList<Map<String, Object>>();
		mockRows.add(new HashMap(){{put("skills","Java");}});
        mockRows.add(new HashMap(){{put("skills","Java");}});
    	Mockito.when(jdbcTemplate.queryForList(Mockito.anyString())).thenReturn(mockRows);
    	List<Integer> resCountList=trendServiceImpl.getBySkillCount();
    	Assert.assertEquals(skillCountList, resCountList);
    }
    
    @Test
    public void getYoYTest()
    {
        List<String> yoyList = new ArrayList<>();
        yoyList.add("2021");
        yoyList.add("2022");
        List<Map<String,Object>> mockRows = new ArrayList<>();
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("date","2021");
        mockRows.add(param);
        Map<String,Object> param1=new HashMap<String,Object>();
        param1.put("date", "2022");
        mockRows.add(param1);
        Map<String,Object> param2=new HashMap<String,Object>();
        param2.put("date", "2022");
        mockRows.add(param2);
        Mockito.when(jdbcTemplate.queryForList(
                Mockito.anyString())).thenReturn(mockRows);
        Assert.assertEquals(yoyList,trendServiceImpl.getByYoY());
    }
    
    @Test
    public void getYoYCountTest() {
    	List<Integer> yoyCountList = new ArrayList<Integer>();
    	yoyCountList.add(1);
    	yoyCountList.add(2);
    	List<Map<String,Object>> mockRows=new ArrayList<Map<String, Object>>();
    	Map<String,Object> param=new HashMap<String,Object>(){
            {put("date","2021"); put("demand",1);}
        };
        mockRows.add(param);
        Map<String,Object> param1=new HashMap<String,Object>(){
            {put("date","2022"); put("demand",1);}
        };
        mockRows.add(param1);
        Map<String,Object> param2=new HashMap<String,Object>(){
            {put("date","2022"); put("demand",1);}
        };
        mockRows.add(param2);
    	Mockito.when(jdbcTemplate.queryForList(Mockito.anyString())).thenReturn(mockRows);
    	List<Integer> resCountList=trendServiceImpl.getByYoYCount();
    	Assert.assertEquals(yoyCountList, resCountList);
    }
    
    @Test
	public void getYoYLocationTest(){
		List<String> yoyList = new ArrayList<String>();
		TreeMap<String,Integer> hMap= new TreeMap<>();
		yoyList.add("2021");
		List<Map<String,Object>> mockRows = new ArrayList<>();
		Map<String,Object> param=new HashMap<String,Object>(){
            {put("date","2021"); put("location","Mumbai");}
        };
        mockRows.add(param);
        Map<String,Object> param1=new HashMap<String,Object>(){
            {put("date","2021"); put("location","Mumbai");}
        };
        mockRows.add(param1);
        Mockito.when(jdbcTemplate.queryForList(
                Mockito.anyString(), ArgumentMatchers.<Object>any())).thenReturn(mockRows);
        Assert.assertEquals(yoyList,trendServiceImpl.getByYoY("Mumbai"));
	}
    
    @Test
	public void getYoYLocationCountTest(){
    	List<Integer> yoyCountList = new ArrayList<Integer>();
    	yoyCountList.add(1);
    	yoyCountList.add(2);
		List<Map<String,Object>> mockRows = new ArrayList<>();
		Map<String,Object> param=new HashMap<String,Object>(){
            {put("date","2021"); put("demand",1);}
        };
        mockRows.add(param);
        Map<String,Object> param1=new HashMap<String,Object>(){
            {put("date","2022"); put("demand",1);}
        };
        mockRows.add(param1);
        Map<String,Object> param2=new HashMap<String,Object>(){
            {put("date","2022"); put("demand",1);}
        };
        mockRows.add(param2);
        Mockito.when(jdbcTemplate.queryForList(
                Mockito.anyString(), ArgumentMatchers.<Object>any())).thenReturn(mockRows);
        Assert.assertEquals(yoyCountList,trendServiceImpl.getByYoYCount("Mumbai"));
	}
    
}
