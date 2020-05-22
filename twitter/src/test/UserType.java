package com.example.twitter.bh.clone.twitterclonebh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usertype")
public class UserType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int idd;
	@Column(name="u_type")
	private String uType;
	
	@Column(name="ut_id")
	private int utId;
	/*
	 * @OneToOne(mappedBy = "userType") private Users user;
	 * 
	 * 
	 * 
	 * public Users getUser() { return user; }
	 * 
	 * public void setUser(Users user) { this.user = user; }
	 */
	 

	UserType(){}

	public UserType(String userType, int id) {
		this.idd = id;
		this.uType = userType;
	}
	
	public int getId() {
		return idd;
	}

	public int getUtId() {
		return utId;
	}

	public void setUtId(int utId) {
		this.utId = utId;
	}

	public void setId(int id) {
		this.idd = id;
	}

	

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}


}
