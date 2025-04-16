package com.als.jdbc.movie;

public class Movie {
	private String title;
	private int age;
	private String genre;
	private String director;
	private String company;
	public Movie() {
		super();
	}
	public Movie(String title, int age, String genre, String director, String company) {
		super();
		this.title = title;
		this.age = age;
		this.genre = genre;
		this.director = director;
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", age=" + age + ", genre=" + genre + ", director=" + director + ", company="
				+ company + "]";
	}
	

}
