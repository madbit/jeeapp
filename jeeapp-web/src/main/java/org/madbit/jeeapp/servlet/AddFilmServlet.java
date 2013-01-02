package org.madbit.jeeapp.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.madbit.jeeapp.persistence.domain.Actor;
import org.madbit.jeeapp.persistence.domain.Director;
import org.madbit.jeeapp.persistence.domain.Film;
import org.madbit.vlib.film.FilmFacade;

@WebServlet(name="addFilm", urlPatterns="/addFilm")
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 4223489592960466469L;
	
	@EJB
	private FilmFacade filmFacade;
	
	Logger logger =  Logger.getLogger(this.getClass());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		logger.info("Add film request");
		
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
			
			if(film.getDirectors() == null)
				film.setDirectors(new ArrayList<Director>());
			film.getDirectors().add(director);
			
			if(film.getActors() == null)
				film.setActors(new ArrayList<Actor>());
			film.getActors().add(actor);
			
			Film dbFilm = filmFacade.addFilm(film);
			
			req.setAttribute("userMessage", "Film added successfully");	
			logger.info("Film added. ID: " + dbFilm.getFilmId());
		} catch (ParseException e) {
			req.setAttribute("userMessage", "An error occurred adding the film");
			logger.error("An error occurred adding the film. " + e.getMessage());
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/success.jsp");
		rd.forward(req, res);
	}
}
