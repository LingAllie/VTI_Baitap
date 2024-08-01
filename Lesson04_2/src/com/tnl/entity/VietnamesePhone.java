package com.tnl.entity;

import java.util.ArrayList;

public class VietnamesePhone extends Phone {

	
	public VietnamesePhone() {
		super();
	}
	
	
	@Override
	public void insertContact(String name, String phone) {
		getContacts().add(new Contacts(name, phone));
		
	}

	@Override
	public void removeContact(String name) {
		if (findContactByName(name) != null) {
			getContacts().remove(findContactByName(name));
		}
	}

	@Override
	public void updateContact(String name, String newPhone) {
		if (findContactByName(name) != null) {
			findContactByName(name).setPhone(newPhone);;
		}
	}

	@Override
	public void searchContact(String name) {
		if (findContactByName(name) != null) {
			System.out.println(findContactByName(name).toString());
		}
		
	}
	
	private Contacts findContactByName(String name) {
		for (Contacts contact: getContacts()) {
			if (contact.getName().equals(name)) {
                return contact;
            }
		}
		return null;
	}

}
