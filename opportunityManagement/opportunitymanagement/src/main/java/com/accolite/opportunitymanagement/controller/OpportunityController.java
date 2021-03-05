package com.accolite.opportunitymanagement.controller;

import com.accolite.opportunitymanagement.mapper.OpportunityMapper;
import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.service.Impl.OpportunityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/opportunity")
public class OpportunityController {

    @Autowired
    OpportunityServiceImpl opportunityServiceImpl;

    @GetMapping(value = "/getAll")
    public List<Opportunity> getAllOpportunity(){
        List<Opportunity> opportunityList = new ArrayList<>();
        opportunityList = opportunityServiceImpl.getAllOpportunity();
        return opportunityList;
    }

    @PostMapping(value = "/add")
    public int addOpportunity(@RequestBody Opportunity opportunity)
    {
        return opportunityServiceImpl.insert(opportunity);
    }

    @PostMapping(value = "/update/{id}")
    public int updateOpportunity(@PathVariable("id") int id,@RequestBody Opportunity opportunity)
    {
        return opportunityServiceImpl.update(opportunity,id);
    }

    @PostMapping(value = "/delete/{id}")
    public int deleteOpportunity(@PathVariable("id") int id)
    {
        return opportunityServiceImpl.delete(id);
    }


}
