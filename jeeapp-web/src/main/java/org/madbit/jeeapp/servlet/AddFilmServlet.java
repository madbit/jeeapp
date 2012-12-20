package org.madbit.jeeapp.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.madbit.jeeapp.persistence.domain.Actor;
import org.madbit.jeeapp.persistence.domain.Director;
import org.madbit.jeeapp.persistence.domain.Film;
import org.madbit.vlib.film.FilmFacade;

public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 4223489592960466469L;
	
	@EJB
	private FilmFacade filmFacade;
	
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
			
			filmFacade.addActor(actor);
			
			Director director = new Director();
			director.setFirstname(directorFirstname);
			director.setMidname(directorMidname);
			director.setLastname(directorLastname);
			
			filmFacade.addDirector(director);
			
			Film film = new Film();
			film.setTitle(title);
			film.setReleaseDate(releaseDate);
			film.setRunningTime(runningTime);
			film.getDirectors().add(director);
			film.getActors().add(actor);
			
			filmFacade.addFilm(film);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}







