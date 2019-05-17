package com.skilldistillery.beerlab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.beerlab.daos.AddressDAO;
import com.skilldistillery.beerlab.daos.BarDAO;
import com.skilldistillery.beerlab.daos.BeerDAO;
import com.skilldistillery.beerlab.daos.UserDAO;
import com.skilldistillery.beerlab.entities.Beer;
import com.skilldistillery.beerlab.entities.Drinker;
import com.skilldistillery.beerlab.entities.User;

@Controller
public class ProfileController {
	
	@Autowired
	AddressDAO adDAO;
	@Autowired
	BarDAO barDAO;
	@Autowired
	BeerDAO beerDAO;
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(path="goToSignup.do")
	public ModelAndView goToSignup() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/WEB-INF/signup.jsp");
		return mv;
	}
	@RequestMapping(path="signup.do")
	public ModelAndView signup(User user, Drinker drinker) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path="login.do")
	public ModelAndView login(User user, HttpSession) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path="addFavorite.do")
	public ModelAndView addFavorite(Drinker drinker, Beer beer) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path="getFavorite.do")
	public ModelAndView getFavorite(Drinker drinker) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path="goToEdit.do")
	public ModelAndView goToEdit(Drinker drinker) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path="editProfile.do")
	public ModelAndView editProfile(User user, Drinker drinker) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path="addBeerRequest.do")
	public ModelAndView addBeerRequest( Beer beer) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}

	

}
