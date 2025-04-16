package com.als.jdbc.controller;

import com.als.jdbc.dao.InformationDao;
import com.als.jdbc.movie.Movie;
import com.als.jdbc.service.InformationService;

public class InformationController {
	InformationService is = new InformationService();
	InformationDao idao = new InformationDao();
	
	public void insertmovie(String title, String age, String genre, String director, String company) {
		
		Movie m = new Movie(title, Integer.parseInt(age), genre, director, company);
		
		
		
	
		
		
		
		
	}
	

}
