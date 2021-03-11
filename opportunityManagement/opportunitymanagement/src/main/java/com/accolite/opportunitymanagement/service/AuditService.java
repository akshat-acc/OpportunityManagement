package com.accolite.opportunitymanagement.service;

import java.util.List;

import com.accolite.opportunitymanagement.model.Audit;

public interface AuditService {
    public List<Audit> getAllAudit();

    public int insert(Audit audit);
}
