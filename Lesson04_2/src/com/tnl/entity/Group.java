package com.tnl.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Group {

	private String groupName;
	private Account creator;
	private ArrayList<Account> accounts;
	private LocalDate createDate;
	
	public Group() {
		this.accounts = new ArrayList<>();
	}
	
	public Group(String groupName, Account creator, ArrayList<Account> accounts, LocalDate createDate) {
		this.groupName = groupName;
		this.creator = creator;
		this.accounts = accounts;
		this.createDate = createDate;
	}
	
	public Group(String groupName, Account creator, String[] usernames, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = new ArrayList<>();
        for (String username : usernames) {
            Account account = new Account();
            account.setUsername(username);
            this.accounts.add(account);
        }
        this.createDate = createDate;
    }
	
	public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", creator=" + creator +
                ", accounts=" + accounts +
                ", createDate=" + createDate +
                '}';
    }
}
