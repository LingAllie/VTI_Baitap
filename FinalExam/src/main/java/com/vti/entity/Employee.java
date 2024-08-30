/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.entity;


public class Employee extends User{

	private String proSkill;
	private int projectId;
	
	public Employee() {}

	public Employee(int id, String fullName, String email, String password, String proSkill, int projectId) {
		super(id, fullName, email, password);
		this.proSkill = proSkill;
		this.projectId = projectId;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Employee [ " +
		           "ProjectId: " + this.projectId + ", " +
		           "ProSkill: " + this.proSkill + ", " +
		           "Employee id: " + super.getId() + ", " +
		           "FullName: " + super.getFullName() + ", " +
		           "Email: " + super.getEmail() + ", " +
		           "Password: " + super.getPassword() +
		           " ]";
	}
	
	


	
	
	
	
	
}
