package pSystem.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "TCiudadanos")
public class Citizen implements Serializable {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellidos;
	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String residencia;
	private String nacionalidad;
	private String dni;

	@OneToOne(mappedBy = "ciudadano")
	private User user;

	Citizen() {}

	public Citizen(String dni) {
		this.dni = dni;
	}

	public Citizen(String nombre, String apellidos, String email, Date fechaNacimiento, String residencia,
			String nacionalidad, String dni) {
		this(dni);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.residencia = residencia;
		this.nacionalidad = nacionalidad;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDni() {
		return dni;
	}

	// No hay set de dni

	public User getUser() {
		return user;
	}

	protected void _setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Ciudadano [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", residencia=" + residencia + ", nacionalidad=" + nacionalidad + ", dni=" + dni
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