package org.madbit.jeeapp.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.madbit.jeeapp.persistence.dao.components.ActorDAO;
import org.madbit.jeeapp.persistence.domain.Actor;
import org.madbit.jeeapp.persistence.domain.Director;
import org.madbit.jeeapp.persistence.domain.Film;
import org.madbit.vlib.film.FilmFacade;

public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 4223489592960466469L;
	
	@EJB
	private FilmFacade filmFacade;
	@EJB ActorDAO actorDAO;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			String title = req.getParameter("title");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date releaseDate = sdf.parse(req.getParameter("releaseDate"));
			short runningTime = Short.parseShort(req.getParameter("runningTime"));
			
			String directorFirstname = req.getParameter("directorFirstname");
			String directorMidname = req.getParameter("directorMidname");
			String directorLastname = req.getParameter("directorLastname");
			String actorFirstname = req.getParameter("actorFirstname");
			String actorMidname = req.getParameter("actorMidname");
			String actorLastname = req.getParameter("actorLastname");
			
			Actor actor = new Actor();
			actor.setFirstname(actorFirstname);
			actor.setMidname(actorMidname);
			actor.setLastname(actorLastname);
			
			Director director = new Director();
			director.setFirstname(directorFirstname);
			director.setMidname(directorMidname);
			director.setLastname(directorLastname);
			
			Film film = new Film();
			film.setTitle(title);
			film.setReleaseDate(releaseDate);
			film.setRunningTime(runningTime);
			
			List<Director> directors = film.getDirectors();
			if(directors == null)
				directors = new ArrayList<Director>();
			directors.add(director);
			
			List<Actor> actors = film.getActors();
			if(actors == null)
				actors = new ArrayList<Actor>();
			actors.add(actor);
			
			filmFacade.addDirector(director);
			filmFacade.addActor(actor);
			filmFacade.addFilm(film);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}







