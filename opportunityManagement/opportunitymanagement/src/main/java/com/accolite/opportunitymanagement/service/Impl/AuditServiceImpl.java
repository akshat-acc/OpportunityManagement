package com.accolite.opportunitymanagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.opportunitymanagement.mapper.AuditMapper;
import com.accolite.opportunitymanagement.model.Audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository("AuditService")
@Transactional
public class AuditServiceImpl {
	
	Logger logger= LoggerFactory.getLogger(AuditServiceImpl.class);
	
	@Autowired
    JdbcTemplate jdbcTemplate;

    public List<Audit> getAllAudit() {
        String SQL = "select * from Audit";
        List<Audit> auditList = jdbcTemplate.query(SQL,new AuditMapper());
        logger.info("Get all audit data");
        return auditList;
    }

    public int insert(Audit audit) {
        String insertSQL = "insert into Audit (managerEmail, date, operation, oldData, newData) values (?, ?, ?, ?, ?)";
        logger.info("Audit "+audit.getOperation()+" by Manager with email: "+audit.getManagerEmail());
        return jdbcTemplate.update(insertSQL,new Object[]{
                audit.getManagerEmail(),
                audit.getDate(),
                audit.getOperation(),
                audit.getOldData(),
                audit.getNewData()
                });
    }
}
