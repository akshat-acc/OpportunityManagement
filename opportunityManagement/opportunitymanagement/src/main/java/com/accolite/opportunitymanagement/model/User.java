package com.accolite.opportunitymanagement.model;

public class User {
	
	// Table columns
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	
	// constructor from superclass()
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// constructor using  fields.
	public User(int userId, String firstName, String lastName, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// getters and setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// overriding toString()
//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
}
