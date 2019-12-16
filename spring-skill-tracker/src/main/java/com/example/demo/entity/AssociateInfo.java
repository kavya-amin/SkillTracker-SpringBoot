package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name="associate_info")
public class AssociateInfo 
{	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "associate_id")
	private int associateId;
	@NotNull
	@Column(name = "associate_first_name")
	private String associateFirstName;
	@NotNull
	@Column(name = "associate_last_name")
	private String associateLastName;
	@NotNull
	@Column(name = "associate_email",unique=true)
	private String associateEmail;
	@NotNull
	private String password;
	//@Column(name = "associate_image")
	//private String associateImage;
	@NotNull
	@Column(name = "associate_mobile")
	private long associateMobile;
	@NotNull
	private String dob;
	@NotNull
	private String gender;
	@NotNull
	private String location;
	@NotNull
	private String country;
	public AssociateInfo(int associateId, @NotNull String associateFirstName, @NotNull String associateLastName,
			@NotNull String associateEmail, @NotNull String password, @NotNull long associateMobile, @NotNull String dob,
			@NotNull String gender, @NotNull String location, @NotNull String country) {
		super();
		this.associateId = associateId;
		this.associateFirstName = associateFirstName;
		this.associateLastName = associateLastName;
		this.associateEmail = associateEmail;
		this.password = password;
		this.associateMobile = associateMobile;
		this.dob = dob;
		this.gender = gender;
		this.location = location;
		this.country = country;
	}
	public AssociateInfo() {
		super();
	}
	public AssociateInfo(@NotNull String associateFirstName, @NotNull String associateLastName,
			@NotNull String associateEmail, @NotNull String password, @NotNull long associateMobile,
			@NotNull String dob, @NotNull String gender, @NotNull String location, @NotNull String country) {
		super();
		this.associateFirstName = associateFirstName;
		this.associateLastName = associateLastName;
		this.associateEmail = associateEmail;
		this.password = password;
		this.associateMobile = associateMobile;
		this.dob = dob;
		this.gender = gender;
		this.location = location;
		this.country = country;
	}
	
	
	
	//@OneToMany(fetch = FetchType.LAZY,mappedBy = "aid", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
		//	CascadeType.DETACH, CascadeType.REFRESH })
	//private List<AssociateSkills> associateSkills;
}