package com.tnl.entity;

public class Department {

	private String nameDepartment;
	private int idDepartment;
	
	public Department(){}
	
	public Department(String nameDepartment) {
		this.nameDepartment = nameDepartment;
		this.idDepartment = 0;
	}
	
	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

	@Override
	public String toString() {
		return "Department [nameDepartment=" + nameDepartment + ", idDepartment=" + idDepartment + "]";
	}
	
	
}
