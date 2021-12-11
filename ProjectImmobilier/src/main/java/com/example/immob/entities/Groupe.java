package com.example.immob.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Groupe {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String groupName;
	
	@ManyToMany
	@JoinTable(name = "User_Groupe", joinColumns = @JoinColumn(name="groupe_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName = "id")
			)
	private List<AppUser> users;
	
	@OneToMany(mappedBy = "groupe")
	private List<Message> msgs;
	public Groupe() {
		super();
	}
	public Groupe(Long id, String groupName, List<AppUser> users, List<Message> msgs) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.users = users;
		this.msgs = msgs;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<AppUser> getUsers() {
		return users;
	}
	public void setUsers(List<AppUser> users) {
		this.users = users;
	}
	public List<Message> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<Message> msgs) {
		this.msgs = msgs;
	}
	

}
