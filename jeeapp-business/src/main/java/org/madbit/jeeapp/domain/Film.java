package org.madbit.jeeapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@Table(name="film")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FILM_ID")
	private String filmId;

    @Temporal( TemporalType.DATE)
	@Column(name="RELEASE_DATE")
	private Date releaseDate;

	@Column(name="RUNNING_TIME")
	private short runningTime;

	@Column(name="TITLE")
	private String title;

	//bi-directional many-to-many association to Director
	@ManyToMany(mappedBy="films")
	private List<Director> directors;

	//bi-directional many-to-many association to Actor
	@ManyToMany(mappedBy="films")
	private List<Actor> actors;

    public Film() {
    }

	public String getFilmId() {
		return this.filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public short getRunningTime() {
		return this.runningTime;
	}

	public void setRunningTime(short runningTime) {
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