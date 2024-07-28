package com.tnl.backend;
import java.time.LocalDate;
import java.util.*;
public class Group {
    int groupId;
    String groupName;
    Account creator;
    LocalDate createDate;
    
    public Group () {}

	public Group(int groupId, String groupName, Account creator, LocalDate createDate) {
		
		this.groupId = groupId;
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", creator=" + creator + ", createDate="
				+ createDate + "]";
	}
	
	

}
