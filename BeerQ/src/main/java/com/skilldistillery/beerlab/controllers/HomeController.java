package com.skilldistillery.beerlab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.beerlab.daos.AddressDAO;
import com.skilldistillery.beerlab.daos.BarDAO;
import com.skilldistillery.beerlab.daos.BeerDAO;
import com.skilldistillery.beerlab.daos.UserDAO;
import com.skilldistillery.beerlab.entities.Bar;
import com.skilldistillery.beerlab.entities.Beer;

@Controller
public class HomeController {

	@Autowired
	AddressDAO adDAO;
	@Autowired
	BarDAO barDAO;
	@Autowired
	BeerDAO beerDAO;
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(path = "/")
	public ModelAndView goToLanding() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/landing.jsp");
		return mv;
	}

	@RequestMapping(path = "search.do")
	public ModelAndView search(String keyword, String type) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("keyword", keyword);
		mv.addObject("type", "search");
		
		if (type.equals("beer")) {
			List<Beer> beersByName = beerDAO.findBeerByName(keyword);
			mv.addObject("list",beersByName );
		}else if (type.equals("bar")) {
			List<Bar> barsByName = barDAO.findBarByName(keyword);
			mv.addObject("list",barsByName );
		}else if (type.equals("beercity")) {
			List<Beer> beersByCity = beerDAO.findBeerByCity(keyword);
			mv.addObject("list",beersByCity );
		}else if (type.equals("barcity")) {
			List<Bar> barsByCity = barDAO.findBarByCity(keyword);
			mv.addObject("list",barsByCity );
		}
		
		mv.setViewName("/WEB-INF/search.jsp");
		return mv;
	}

	@RequestMapping(path = "barBrowse.do")
	public ModelAndView barBrowse() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("type", "browse");

		List<Bar> bars = barDAO.findAllBars();
		mv.addObject("bars", bars);
		mv.setViewName("/WEB-INF/search.jsp");
		return mv;
	}

	@RequestMapping(path = "beerBrowse.do")
	public ModelAndView beerBrowse() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("type", "browse");

		List<Beer> beers = beerDAO.findAllBeers();
		mv.addObject("beers", beers);
		mv.setViewName("/WEB-INF/search.jsp");

		return mv;
	}

	@RequestMapping(path = "getBeer.do")
	public ModelAndView getBeer(Beer beer) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("beer", beer);
		mv.addObject("type", "beer");
		mv.setViewName("/WEB-INF/profile.jsp");

		return mv;
	}

	@RequestMapping(path = "getBar.do")
	public ModelAndView getBar(Bar bar) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bar", bar);
		mv.addObject("type", "bar");
		mv.setViewName("/WEB-INF/profile.jsp");

		return mv;
	}

}
