package com.bhtwitter.twitter.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usertype")
public class UserType {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="type")
	private String type;
	
	@OneToOne(mappedBy = "userType", cascade = CascadeType.ALL)
	private Users user;
	
	UserType(){}

	private UserType(String type, Integer Id) {
		this.id=id;
		this.type = type;
	}
	
	
	
}