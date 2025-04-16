package com.als.jdbc.movietitle;

public class Movietitle {
	private String title;

	@Override
	public String toString() {
		return  title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Movietitle(String title) {
		super();
		this.title = title;
	}

	public Movietitle() {
		super();
	}

}
