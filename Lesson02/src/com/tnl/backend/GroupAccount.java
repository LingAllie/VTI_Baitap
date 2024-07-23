package com.tnl.backend;
import java.util.*;
public class GroupAccount {
	Group group;
	Account account;
	Date joinDate;
	
	public GroupAccount () {}

	public GroupAccount(Group group, Account account, Date joinDate) {
		
		this.group = group;
		this.account = account;
		this.joinDate = joinDate;
	}
	
	
}
