package com.als.jdbc.movie;

public class Movie {
	private int titleno;
	private String title;
	private int age;
	private String genre;
	private String director;
	private String company;
	
	public Movie() {
		super();
	}
	
	public Movie(int titleno, String title, int age, String genre, String director, String company) {
		super();
		this.titleno = titleno;
		this.title = title;
		this.age = age;
		this.genre = genre;
		this.director = director;
		this.company = company;
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
	public int getTitleno() {
		return titleno;
	}

	public void setTitleno(int titleno) {
		this.titleno = titleno;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "NO" + titleno + "," + title + "," + age + ",=" + genre + ","
				+ director + ", " + company ;
	}
	
	
	

}
