package org.madbit.jeeapp.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the director database table.
 * 
 */
@Entity
public class Director implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DIRECTOR_ID")
	private int directorId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BIRTH_DAY")
	private Date birthDay;

	private String firstname;

	private String lastname;

	private String midname;

	//bi-directional many-to-many association to Film
	@ManyToMany(mappedBy="directors")
	private List<Film> films;

	public Director() {
	}

	public int getDirectorId() {
		return this.directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMidname() {
		return this.midname;
	}

	public void setMidname(String midname) {
		this.midname = midname;
	}

	public List<Film> getFilms() {
		return this.films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

}