package com.accolite.opportunitymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.opportunitymanagement.model.Opportunity;
import com.accolite.opportunitymanagement.service.Impl.OpportunityServiceImpl;

@RestController
@RequestMapping("/opportunity")
public class OpportunityController {

    @Autowired
    OpportunityServiceImpl opportunityServiceImpl;

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/getAll")
    public List<Opportunity> getAllOpportunity(){
        List<Opportunity> opportunityList = new ArrayList<>();
        opportunityList = opportunityServiceImpl.getAllOpportunity();
        return opportunityList;
    }
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/add")
    public int addOpportunity(@RequestBody Opportunity opportunity)
    {	
        return opportunityServiceImpl.insert(opportunity);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/update/{id}")
    public int updateOpportunity(@PathVariable("id") int id,@RequestBody Opportunity opportunity)
    {
        return opportunityServiceImpl.update(opportunity,id);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @DeleteMapping(value = "/delete/{id}")
    public int deleteOpportunity(@PathVariable("id") int id)
    {
        return opportunityServiceImpl.delete(id);
    }
}
