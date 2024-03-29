package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Vaccins")
public class Vaccin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="phone") 
	private long  phone;
 
@OneToMany(targetEntity = Person.class,cascade = CascadeType.ALL)
@JoinColumn(name="cp_fk",referencedColumnName = "id")
private List<Person> persons;
	public long getId() {
		return id;
	}
	public Vaccin() {}
	
	public Vaccin(String firstname, String lastname, String emailId ,long phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone =phone;
 	}


   
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
 


}
