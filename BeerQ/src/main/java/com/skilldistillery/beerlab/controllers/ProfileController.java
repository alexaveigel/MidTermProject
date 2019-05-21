package com.skilldistillery.beerlab.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.beerlab.daos.AddressDAO;
import com.skilldistillery.beerlab.daos.BarDAO;
import com.skilldistillery.beerlab.daos.BeerDAO;
import com.skilldistillery.beerlab.daos.UserDAO;
import com.skilldistillery.beerlab.entities.Address;
import com.skilldistillery.beerlab.entities.Beer;
import com.skilldistillery.beerlab.entities.Drinker;
import com.skilldistillery.beerlab.entities.FavoriteBeer;
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

	@RequestMapping(path = "goToSignup.do")
	public ModelAndView goToSignup() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/WEB-INF/signup.jsp");
		return mv;
	}

	@RequestMapping(path = "login.do")
	public ModelAndView login(User user, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User activeUser = userDAO.findUserByUserNameAndPassword(user.getUsername(), user.getPassword(), user);
		if (activeUser != null) {
			session.setAttribute("user", activeUser);
			Drinker drinker = activeUser.getDrinker();
			session.setAttribute("drinker", drinker);
			mv.setViewName("/WEB-INF/home.jsp");
		} else {
			mv.addObject("message", "Your entry doesn't match our records, please try again.");
			mv.setViewName("/WEB-INF/landing.jsp");
		}

		return mv;
	}

	@RequestMapping(path = "addFavorite.do")
	public ModelAndView addFavorite(User user, Beer beer) {
		ModelAndView mv = new ModelAndView();
		beerDAO.addBeerToFavList(beer, user);
		mv.addObject("message", "Added to Favorites");
		mv.addObject("beer", beer);
		mv.setViewName("/WEB-INF/objectProfile.jsp");
		return mv;
	}

	@RequestMapping(path = "getFavorite.do")
	public ModelAndView getFavorite(User user) {
		ModelAndView mv = new ModelAndView();
		List<FavoriteBeer> list = beerDAO.getListOfFavBeer(user);
		mv.addObject("listFavBeers", list);
		mv.addObject("type", "fave");
		mv.setViewName("/WEB-INF/beerSearch.jsp");
		return mv;
	}

	@RequestMapping(path = "editProfile.do", method = RequestMethod.POST)
	public ModelAndView editProfile(Drinker drinker, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Drinker current = (Drinker) session.getAttribute("drinker");
		drinker.setAddress(current.getAddress());
		drinker = userDAO.updateDrinker(drinker, current.getId());
		session.setAttribute("drinker", drinker);
		mv.setViewName("/WEB-INF/userProfile.jsp");
		return mv;
	}
	@RequestMapping(path = "editAddress.do", method = RequestMethod.POST )
	public ModelAndView editAddress(Address address, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Drinker currDrinker = (Drinker) session.getAttribute("drinker");
		Address current = currDrinker.getAddress();
		address = adDAO.updateAddress(current.getId(), address);
		currDrinker.setAddress(address);
		session.setAttribute("drinker", currDrinker);
		mv.setViewName("/WEB-INF/userProfile.jsp");
		return mv;
	}
	

	@RequestMapping(path = "goToEditProfile.do")
	public ModelAndView goToEdit(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("type", "edit");
		mv.setViewName("/WEB-INF/userProfile.jsp");
		return mv;
	}

	@RequestMapping(path = "addBeerRequest.do")
	public ModelAndView addBeerRequest(Beer beer) {
		ModelAndView mv = new ModelAndView();
		beerDAO.createBeer(beer);
		mv.addObject("message", "Your submission has been recieved");
		mv.setViewName("/WEB-INF/userProfile.jsp");
		return mv;
	}

	@RequestMapping(path = "signup.do", method = RequestMethod.POST)
	public ModelAndView checkUniqueEmail(User user, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User uniqueUser = userDAO.createUser(user);
		if (uniqueUser == null) {
			mv.addObject("message", "Your username is taken, try again");
			mv.setViewName("/WEB-INF/signup.jsp");
			return mv;
		} else {
			mv.addObject("form", "drinker");
			session.setAttribute("user", uniqueUser);
			mv.setViewName("/WEB-INF/signup.jsp");

			System.out.println(uniqueUser);
			return mv;
		}

	}

	@RequestMapping(path = "drinker.do", method = RequestMethod.POST)
	public ModelAndView addDrinkerToTable(Drinker drinker, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		drinker.setUser(user);
		Drinker newDrinker = userDAO.createDrinker(drinker);
		session.setAttribute("drinker", newDrinker);
		mv.addObject("form", "address");
		mv.addObject("drinker", newDrinker);
		mv.setViewName("/WEB-INF/signup.jsp");
		return mv;
	}

	@RequestMapping(path = "address.do", method = RequestMethod.POST)
	public ModelAndView addAddressToDrinker(Address address, HttpSession session) {
		System.out.println(address);
		ModelAndView mv = new ModelAndView();
		Drinker drinker = (Drinker) session.getAttribute("drinker");
		address = adDAO.createAddress(address);
		drinker.setAddress(address);
		userDAO.updateDrinker(drinker, drinker.getId());
		mv.setViewName("/WEB-INF/home.jsp");
		return mv;
	}

}
