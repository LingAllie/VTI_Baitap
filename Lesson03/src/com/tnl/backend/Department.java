package com.tnl.backend;

public class Department {

	int id;
    String name;
    String address; // Assuming there's an address field

    public Department(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    @Override
    public String toString() {
    	 return "Department [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
    	Department dep = (Department) obj;
    	return this.name.toLowerCase().equals(dep.name.toLowerCase()) ? true : false;
    }
    
    public boolean equalsByName(String name) {
    	return this.name.equalsIgnoreCase(name) ? true : false;
    }
}
