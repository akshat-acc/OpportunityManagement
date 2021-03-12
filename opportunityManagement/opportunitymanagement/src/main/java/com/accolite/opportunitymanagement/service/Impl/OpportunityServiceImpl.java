package com.accolite.opportunitymanagement.service.Impl;

import com.accolite.opportunitymanagement.mapper.OpportunityMapper;
import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository("OpportunityService")
@Transactional
public class OpportunityServiceImpl implements OpportunityService  {
	
	Logger logger= LoggerFactory.getLogger(OpportunityServiceImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Opportunity> getAllOpportunity() {
        String SQL = "select * from Opportunity";
        List<Opportunity> opportunityList = jdbcTemplate.query(SQL,new OpportunityMapper());
        logger.info("Get all opportunities");
        return opportunityList;
    }

    @Override
    public int insert(Opportunity opportunity) {
        String insertSQL = "insert into Opportunity (description,location,skills,email,minExperience,demand,date) values (?, ?, ?, ?, ?, ?, ?)";
        logger.info("Added opportunity with OpportunityId: "+opportunity.getId());
        return jdbcTemplate.update(insertSQL,new Object[]{
                opportunity.getDescription(),
                opportunity.getLocation(),
                opportunity.getSkills(),
                opportunity.getEmail(),
                opportunity.getMinExperience(),
                opportunity.getDemand(),
                opportunity.getDate()});
    }

    @Override
    public int update(Opportunity opportunity,int id) {
        String SQL = "UPDATE opportunity SET description=?, location=?, skills=?, minExperience=?, demand=? , date = ? WHERE id=?";
        logger.info("Updated opportunity with Id: "+id);
        return jdbcTemplate.update(SQL,new Object[]{
                opportunity.getDescription(),
                opportunity.getLocation(),
                opportunity.getSkills(),
                opportunity.getMinExperience(),
                opportunity.getDemand(),
                opportunity.getDate(),
                id
        });
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM opportunity WHERE id =?";
        logger.info("Deleted opportunity with Id: "+id);
        return jdbcTemplate.update(SQL,new Object[]{id});
    }
}
