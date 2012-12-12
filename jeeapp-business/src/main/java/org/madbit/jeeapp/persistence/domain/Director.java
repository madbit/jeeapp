package org.madbit.jeeapp.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the director database table.
 * 
 */
@Entity
@Table(name="director")
public class Director implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DIRECTOR_ID")
	private String directorId;

	@Column(name="FIRSTNAME")
	private String firstname;

	@Column(name="LASTNAME")
	private String lastname;

	@Column(name="MIDNAME")
	private String midname;

	//bi-directional many-to-many association to Film
    @ManyToMany
	@JoinTable(
		name="directed"
		, joinColumns={
			@JoinColumn(name="DIRECTOR_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FILM_ID")
			}
		)
	private List<Film> films;

    public Director() {
    }

	public String getDirectorId() {
		return this.directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
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