package com.skilldistillery.beerlab.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.beerlab.daos.AddressDAO;
import com.skilldistillery.beerlab.daos.BarDAO;
import com.skilldistillery.beerlab.daos.BeerDAO;
import com.skilldistillery.beerlab.daos.UserDAO;
import com.skilldistillery.beerlab.entities.Bar;
import com.skilldistillery.beerlab.entities.Beer;
import com.skilldistillery.beerlab.entities.Drinker;
import com.skilldistillery.beerlab.entities.User;

@Controller
public class NavbarController {

	@Autowired
	AddressDAO adDAO;
	@Autowired
	BarDAO barDAO;
	@Autowired
	BeerDAO beerDAO;
	@Autowired
	UserDAO userDAO;

	@RequestMapping(path = "goToHome.do", method = RequestMethod.GET)
	public ModelAndView goToHome(User user, Drinker drinker) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/WEB-INF/home.jsp");
		return mv;
	}

	@RequestMapping(path = "goToProfile.do", method = RequestMethod.GET)
	public ModelAndView goToProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Drinker drinker = (Drinker) session.getAttribute("drinker");
		System.out.println(drinker);
		mv.addObject("drinker", drinker);
		mv.setViewName("/WEB-INF/userProfile.jsp");
		return mv;
	}

	@RequestMapping(path = "logOut.do", method = RequestMethod.GET)
	public ModelAndView logOut() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/WEB-INF/landing.jsp");
		return mv;
	}

	@RequestMapping(path = "goToAdmin.do", method = RequestMethod.GET)
	public ModelAndView goToAdmin(User user, Drinker drinker) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/WEB-INF/admin.jsp");
		return mv;
	}

	@RequestMapping(path = "adminSearchBeer.do", method = RequestMethod.GET)
	public ModelAndView adminSearchBeer(String keyword) {
		ModelAndView mv = new ModelAndView();

		List<Beer> listBeersKeyword = beerDAO.findBeerByName(keyword);

		mv.addObject("type", "Search Beers");
		mv.addObject("listOfBeers", listBeersKeyword);
		mv.setViewName("/WEB-INF/admin.jsp");
		return mv;

	}

	@RequestMapping(path = "adminSearchBar.do", method = RequestMethod.GET)
	public ModelAndView adminSearchBar(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Bar> listBarsKeyword = barDAO.findBarByName(keyword);
		mv.addObject("type", "Search Bars");
		mv.addObject("listOfBars", listBarsKeyword);
		mv.setViewName("/WEB-INF/admin.jsp");
		return mv;
	}

	@RequestMapping(path = "adminSearchUser.do", method = RequestMethod.GET)
	public ModelAndView adminSearchUser(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<User> findUserByKeyword = userDAO.findUserByUsername(keyword);
		mv.addObject("type", "Search Users");
		mv.addObject("userByKeyword", findUserByKeyword);
		mv.setViewName("/WEB-INF/admin.jsp");
		return mv;
	}

	@RequestMapping(path = "adminConfirmBeerWaitList.do", method = RequestMethod.GET)
	public ModelAndView adminConfirmBeerWaitList(Beer beer) {
		ModelAndView mv = new ModelAndView();

		List<Beer> unapprovedBeer = beerDAO.unapproved();
		
		mv.addObject("type", "unapproved");
		mv.addObject("unapprovedBeerList", unapprovedBeer);
		mv.setViewName("/WEB-INF/admin.jsp");
		return mv;
	}

	@RequestMapping(path = "adminConfirmBeerAdd.do", method = RequestMethod.POST)
	public ModelAndView adminConfirmBeerAdd(@RequestParam int beer) {
		ModelAndView mv = new ModelAndView();
		Beer approveBeer = beerDAO.approveBeer(beer);
		mv.addObject("approvedBeer", approveBeer);
		mv.setViewName("/WEB-INF/admin.jsp");

		return mv;
	}
	
	@RequestMapping(path = "addBeerToBar.do", method = RequestMethod.POST)
	public ModelAndView addBeerToBar(int beerId, int barId) {
		ModelAndView mv = new ModelAndView();
		Bar bar = barDAO.findBarById(barId);
		Beer beer = beerDAO.findBeerById(beerId);
		
//		bar.addBeer(beer);
//		barDAO.updateBar(bar.getId(), bar);
		mv.addObject(bar);
		barDAO.addBeerToBarInventory(beer, bar);
		mv.setViewName("/WEB-INF/admin.jsp");
		return mv;
	}

}
