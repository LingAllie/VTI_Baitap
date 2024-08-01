package com.tnl.entity;

import java.util.ArrayList;

public abstract class Phone {

	private ArrayList<Contacts> contacts;
	
	public Phone() {
        contacts = new ArrayList<>();
    }
	
	public ArrayList<Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contacts> contacts) {
		this.contacts = contacts;
	}


	public abstract void insertContact(String name, String phone);
	public abstract void removeContact(String name);
	public abstract void updateContact(String name, String newPhone);
	public abstract void searchContact(String name);
	
	
}
