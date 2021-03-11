package com.accolite.opportunitymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.opportunitymanagement.model.Audit;
import com.accolite.opportunitymanagement.service.Impl.AuditServiceImpl;


@RestController
@RequestMapping("/audit")
public class AuditController {
	
	@Autowired
	AuditServiceImpl auditServiceImpl;
	
    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/getAllAudit")
    public List<Audit> getAllAudit(){
        List<Audit> opportunityList = new ArrayList<>();
        opportunityList = auditServiceImpl.getAllAudit();
        return opportunityList;
    }
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/add")
    public int addAudit(@RequestBody Audit audit)
    {	
        return auditServiceImpl.insert(audit);
    }
}
