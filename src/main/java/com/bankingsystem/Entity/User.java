package com.bankingsystem.Entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Data
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String firstName;
	
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable =false)
	private Role role;
	
	private String phoneNumber;
	
	@Column(updatable=false)
	private LocalDateTime createdDate;
	
	@PrePersist
	protected void onCreate() {
		createdDate=LocalDateTime.now();
		if(status ==null) status="Active";
	}
	
	private String status; //(Active,Suspended,Deleted)
}

enum Role{
	CUSTOMER, EMPLOYEE, ADMIN
}