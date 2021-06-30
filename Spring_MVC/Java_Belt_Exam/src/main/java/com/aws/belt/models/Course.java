package com.aws.belt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@Size(min = 2, message="Size shoud be more than 2")
	private String name;
	
	@Column
	@Range(min=1, max=100, message="Capacity Range Should be in [1, 100]")
	private Integer capacity;

//	@Column
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date date;

//	@Column
//	@Size(min = 1)
//	private String city;
//
//	@Column
//	@Size(min = 2, max = 2)
//	private String state;

	@Column(updatable = false)
	private Date createdAt;

	@Column
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "host_id")
	private User host;

	@Column
	@Size(min = 2, message="Size shoud be more than 2")
	private String instructer;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "courses_users", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> joiners;

//	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
//	private List<Message> messages;

	public Course() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
	
	

	public String getInstructer() {
		return instructer;
	}

	public void setInstructer(String instructer) {
		this.instructer = instructer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getJoiners() {
		return joiners;
	}

	public void setJoiners(List<User> joiners) {
		this.joiners = joiners;
	}

	public boolean equals(Course other) {
		return this.getId() == other.getId();
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
