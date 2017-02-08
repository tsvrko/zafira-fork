package com.qaprosoft.zafira.models.db;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

@JsonInclude(Include.NON_NULL)
public class User extends AbstractEntity implements Comparable<User>
{
	private static final long serialVersionUID = 2720141152633805371L;

	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private List<Group> groupList;

	public User()
	{
	}
	
	public User(long id)
	{
		super.setId(id);
	}
	
	public User(String userName)
	{
		this.userName = userName;
	}
	
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	@Override
	public int compareTo(User user) {
		return userName.compareTo(user.getUserName());
	}
}
