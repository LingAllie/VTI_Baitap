package com.tnl.entity;

import com.tnl.backend.IStudent;

public class Studentt implements IStudent{

	private int id, group;
	private String name;
	
	public Studentt() {}
	
	public Studentt(int id, int group, String name) {
		super();
		this.id = id;
		this.group = group;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void điemDanh() {
		System.out.println(this.getName() + " điểm danh");
		
	}

	@Override
	public void hocBai() {
		System.out.println(this.getName() + " đang học bài");
		
	}

	@Override
	public void điDonVeSinh() {
		System.out.println(this.getName() + " đang đi dọn vệ sinh");
		
	}
	
	
	
	
}
