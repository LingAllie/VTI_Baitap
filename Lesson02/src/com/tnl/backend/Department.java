package com.tnl.backend;

public class Department {
	
	int departmentId;
	String departmentName;
	
	public Department () {}

	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ Id: " + this.departmentId + ", Department Name: " + this.departmentName + " ]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Department dep = (Department) obj;
		
//		 return departmentName != null ? 
//				 departmentName.equals(dep.departmentName) : dep.departmentName == null;
		return departmentName.equals(dep.departmentName) ? true : false;
	}
	
	

}
