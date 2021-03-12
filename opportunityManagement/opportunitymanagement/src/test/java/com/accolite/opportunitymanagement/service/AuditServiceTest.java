package com.accolite.opportunitymanagement.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.opportunitymanagement.mapper.AuditMapper;
import com.accolite.opportunitymanagement.model.Audit;
import com.accolite.opportunitymanagement.service.Impl.AuditServiceImpl;

@SpringBootTest
public class AuditServiceTest {
	
    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    AuditServiceImpl auditServiceImpl;
    
    @Before
    private Audit createAudit()
    {
    	Audit audit1=new Audit();
        Audit audit = new Audit(1,"accolite.digital@accolite.digital.com",new Date(System.currentTimeMillis()),"Create","'{}'","'{\\\"oppid\\\":\\\"0\\\",\\\"description\\\":\\\"Data Engineer\\\",\\\"location\\\":\\\"Hyderabad\\\",\\\"date\\\":\\\"2021-03-27T00:00:00.000Z\\\",\\\"skills\\\":\\\"Python,Nlp\\\",\\\"demand\\\":5,\\\"minExperience\\\":3,\\\"email\\\":\\\"akshat.mehta@accolitedigital.com\\\"}'");
        return audit;
    }
    
    @Test
    public void insertAuditTest(){
        Audit audit = createAudit();
        List<Audit> auditList=auditServiceImpl.getAllAudit();
        Mockito.when(jdbcTemplate.update(
                Mockito.anyString(),
                (Object[])Mockito.any()
        )).thenReturn(1);
        Assert.assertEquals(1,auditServiceImpl.insert(audit));
    }
       
    @Test
    public void getAllUserTest(){
        ArrayList<Audit> auditList = new ArrayList<>();
        Audit audit = createAudit();
        auditList.add(audit);
        Mockito.when(jdbcTemplate.query(
                Mockito.anyString(),
                Mockito.any(AuditMapper.class))).thenReturn(auditList);
        Assert.assertEquals(auditList.size(),auditServiceImpl.getAllAudit().size());
    }
    

}
