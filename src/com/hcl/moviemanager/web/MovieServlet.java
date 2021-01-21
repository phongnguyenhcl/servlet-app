package com.hcl.moviemanager.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.moviemanager.model.Movie;
import com.hcl.moviemanager.dao.MovieDAO;

@WebServlet("/show")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDAO movieDAO;

	public void init() {
		movieDAO = new MovieDAO();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		showUser(req, resp);
	}

	private void showUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		Movie movie = movieDAO.selectMovie(id);
		if (movie == null) {
			out.printf("NOT FOUND ERROR: Movie with id of %d is not in the database.\n", id);
		} else {
			out.println(movie);
		}
	}
}
