package com.accolite.opportunitymanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.opportunitymanagement.model.Audit;
import com.accolite.opportunitymanagement.model.Opportunity;


public class AuditMapper implements RowMapper<Audit>{
    public Audit mapRow(ResultSet rs, int rowNum) throws SQLException {
        Audit audit = new Audit();
        audit.setId(rs.getInt("Id"));
        audit.setManagerEmail(rs.getString("managerEmail"));
        audit.setDate(rs.getDate("date"));
        audit.setOperation(rs.getString("operation"));
        audit.setOldData(rs.getString("oldData"));
        audit.setNewData(rs.getString("newData"));
        return audit;
    }
}
