package com.hcl.moviemanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.moviemanager.model.Movie;

public class MovieDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/moviedb?useSSL=false";
	private String jdbcUserName = "root";
	private String jdbcPassword = "root";

	private static final String SELECT_MOVIE_BY_ID = "select movie_id, movie_title, movie_rating, movie_year from movies where movie_id=?";

	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL exception");
			e.printStackTrace();
		}

		return connection;
	}

	public Movie selectMovie(int id) {
		Movie movie = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIE_BY_ID)) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("movie_title");
				double rating = rs.getDouble("movie_rating");
				int year = rs.getInt("movie_year");
				movie = new Movie(id, name, rating, year);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}

}
