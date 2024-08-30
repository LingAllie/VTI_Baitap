/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.entity;


public class Manager extends User{

	private int expInYear;
	private int projectId;
	
	public Manager() {}

	public Manager(int id, String fullName, String email, String password, int expInYear, int projectId) {
		super(id, fullName, email, password);
		this.expInYear = expInYear;
		this.projectId = projectId;
	}

	public int getExpInYear() {
		return this.expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Manager [ " +
		           "Project Id: " + this.projectId + ", " +
		           "ExpInYear: " + this.expInYear + ", " +
		           "Manager Id: " + super.getId() + ", " +
		           "FullName: " + super.getFullName() + ", " +
		           "Email: " + super.getEmail() + ", " +
		           "Password: " + super.getPassword() +
		           " ]";
	}
	
	

	
	
	
	
	
}
