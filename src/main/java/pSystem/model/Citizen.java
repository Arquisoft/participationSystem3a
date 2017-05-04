package pSystem.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "TCitizens")
public class Citizen implements Serializable {
		
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String surname;
	private String email;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String residence;
	private String nationality;
	private String dni;

	@OneToOne(mappedBy = "citizen")
	private User user;

	Citizen() {}

	public Citizen(String dni) {
		this.dni = dni;
	}

	public Citizen(String name, String surname, String email, Date birthday, String residence, String nationality, String dni) {
		this(dni);
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birthday = birthday;
		this.residence = residence;
		this.nationality = nationality;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date fechaNacimiento) {
		this.birthday = fechaNacimiento;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDni() {
		return dni;
	}

	public User getUser() {
		return user;
	}

	protected void _setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Ciudadano [nombre=" + name + ", apellidos=" + surname + ", email=" + email + ", fechaNacimiento="
				+ birthday + ", residencia=" + residence + ", nacionalidad=" + nationality + ", dni=" + dni
				+ ", usuario=" + user +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citizen other = (Citizen) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
}