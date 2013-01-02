package org.madbit.jeeapp.persistence.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FILM_ID")
	private int filmId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RELEASE_DATE")
	private Date releaseDate;

	@Column(name="RUNNING_TIME")
	private int runningTime;

	private String title;

	//bi-directional many-to-many association to Director
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="directed"
		, joinColumns={
			@JoinColumn(name="FILM_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="DIRECTOR_ID")
			}
		
		)
	private List<Director> directors;

	//bi-directional many-to-many association to Actor
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="starring"
		, joinColumns={
			@JoinColumn(name="FILM_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ACTOR_ID")
			}
		)
	private List<Actor> actors;

	public Film() {
	}

	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRunningTime() {
		return this.runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Director> getDirectors() {
		return this.directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Actor> getActors() {
		return this.actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

}