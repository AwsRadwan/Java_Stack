package com.aws.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@Size(min = 2)
	private String firstName;

	@Column
	@Size(min = 2)
	private String lastName;

	@Email(message = "Email must be valid")
	private String email;

	@Column
	@Size(min = 1)
	private String city;

	@Column
	@Size(min = 2, max = 2)
	private String state;

	@Size(min = 5, message = "Password must be greater than 5 characters")
	private String password;

	@Transient
	@Size(min = 5, message = "Password must be greater than 5 characters")
	private String passwordConfirmation;

	@Column(updatable = false)
	private Date createdAt;

	private Date updatedAt;

	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<Message> messages;

	@OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
	private List<Event> hostedEvents;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "events_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> joinedEvents;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Event> getHostedEvents() {
		return hostedEvents;
	}

	public void setHostedEvents(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}

	public List<Event> getJoinedEvents() {
		return joinedEvents;
	}

	public void setJoinedEvents(List<Event> joinedEvents) {
		this.joinedEvents = joinedEvents;
	}

	public boolean equals(User other) {
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
