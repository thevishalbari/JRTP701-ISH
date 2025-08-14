package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CITIZEN_APPLICATION")
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class CitizenAppRegistrationEntity {

	@Id
	@SequenceGenerator(name = "gen_seq", sequenceName = "app_id_seq",initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen_seq", strategy = GenerationType.SEQUENCE)
	private Integer appId;
	
	@Column(length=30)
	private String fullName;
	
	@Column(length=30)
	private String email;
	
	@Column(length=1)
	private String gender;
	
	private Long phoneNo;
	private Long ssn;
	private LocalDate dob;
	
	@Column(length=30)
	private String stateName;
	
	@Column(length=30)
	private String createdBy;

	@Column(length=30)	
	private String updatedBy;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime creationTime;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime updationTime;
	
}
