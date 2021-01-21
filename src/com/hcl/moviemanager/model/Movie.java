package com.hcl.moviemanager.model;

public class Movie {

	protected int id;
	protected String name;
	protected double rating;
	protected int year;
	
	public Movie(int id, String name, double rating, int year) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.year = year;
	}

	private int getId() {
		return id;
	}

	private String getName() {
		return name;
	}

	private double getRating() {
		return rating;
	}

	private int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", rating=" + rating + ", year=" + year + "]";
	}
	
	
	
	
	
	
	
	
}
