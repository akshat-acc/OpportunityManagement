package com.accolite.opportunitymanagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.opportunitymanagement.mapper.AuditMapper;
import com.accolite.opportunitymanagement.model.Audit;
import com.accolite.opportunitymanagement.model.Opportunity;

@Repository("AuditService")
@Transactional
public class AuditServiceImpl {
	@Autowired
    JdbcTemplate jdbcTemplate;

    public List<Audit> getAllAudit() {
        String SQL = "select * from Audit";
        List<Audit> auditList = jdbcTemplate.query(SQL,new AuditMapper());
        return auditList;
    }

    public int insert(Audit audit) {
        String insertSQL = "insert into Audit (managerEmail, date, operation, oldData, newData) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(insertSQL,new Object[]{
                audit.getManagerEmail(),
                audit.getDate(),
                audit.getOperation(),
                audit.getOldData(),
                audit.getNewData()
                });
    }
}
