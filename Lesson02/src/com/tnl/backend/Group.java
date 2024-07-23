package com.tnl.backend;
import java.util.*;
public class Group {
    int groupId;
    String groupName;
    Account creator;
    Date createDate;
    
    public Group () {}

	public Group(int groupId, String groupName, Account creator, Date createDate) {
		
		this.groupId = groupId;
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
	}

}
