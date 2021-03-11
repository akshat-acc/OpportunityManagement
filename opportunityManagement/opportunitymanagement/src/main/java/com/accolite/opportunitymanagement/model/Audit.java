package com.accolite.opportunitymanagement.model;

import java.sql.Date;

public class Audit {
    private int id;
    private String managerEmail;
    private Date date;
    private String operation;
    private String oldData;
    private String newData;

	public Audit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Audit(int id, String managerEmail, Date date, String operation, String oldData, String newData) {
		super();
		this.id = id;
		this.managerEmail = managerEmail;
		this.date = date;
		this.operation = operation;
		this.oldData = oldData;
		this.newData = newData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOldData() {
		return oldData;
	}

	public void setOldData(String oldData) {
		this.oldData = oldData;
	}

	public String getNewData() {
		return newData;
	}

	public void setNewData(String newData) {
		this.newData = newData;
	}  
}
