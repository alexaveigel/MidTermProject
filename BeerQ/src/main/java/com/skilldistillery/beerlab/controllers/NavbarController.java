package com.skilldistillery.beerlab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.beerlab.entities.Beer;
import com.skilldistillery.beerlab.entities.Drinker;
import com.skilldistillery.beerlab.entities.User;

@Controller
public class NavbarController {

	@RequestMapping(path = "goToHome.do")
	public ModelAndView goToHome(User user, Drinker drinker) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "goToProfile.do")
	public ModelAndView goToProfile(User user, Drinker drinker) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "logOut.do")
	public ModelAndView logOut() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "goToAdmin.do")
	public ModelAndView goToAdmin(User user, Drinker drinker) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "adminSearchBeer.do")
	public ModelAndView adminSearchBeer(String keyword) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "adminSearchBar.do")
	public ModelAndView adminSearchBar(String keyword) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "adminSearchUser.do")
	public ModelAndView adminSearchUser(String keyword) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "adminConfirmBeerAdd.do")
	public ModelAndView adminConfirmBeerAdd(Beer beer) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
}
