package com.example.Hostel.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String role;
	private String name;
	private String lastName;
	private LocalDate dateOfBirth;
	private long moNo;
	@Column(unique = true)
	private String email;
	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Booking> getbooking;

	public List<Booking> getGetbooking() {
		return getbooking;
	}

	public void setGetbooking(List<Booking> getbooking) {
		this.getbooking = getbooking;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, email, id, lastName, moNo, name, password, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return dateOfBirth == other.dateOfBirth && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(lastName, other.lastName) && moNo == other.moNo && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMoNo() {
		return moNo;
	}

	public void setMoNo(long moNo) {
		this.moNo = moNo;
	}

}
