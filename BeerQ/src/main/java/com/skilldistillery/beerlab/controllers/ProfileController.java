package com.skilldistillery.beerlab.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public ModelAndView login(User user, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User activeUser = userDAO.findUserByUserNameAndPassword(user.getUsername(), user.getPassword(), user);
		if (activeUser != null) {
			session.setAttribute("user", activeUser);
			Drinker drinker = activeUser.getDrinker();
			session.setAttribute("drinker", drinker);
			mv.addObject("user", session.getAttribute("user"));
			mv.setViewName("/WEB-INF/home.jsp");
		} else {
			mv.addObject("message", "Your entry doesn't match our records, please try again.");
			mv.setViewName("/WEB-INF/landing.jsp");
		}

		return mv;
	}

	@RequestMapping(path = "addFavorite.do", method = RequestMethod.POST)
	public ModelAndView addFavorite(HttpSession session, @RequestParam int beerId) {
		ModelAndView mv = new ModelAndView();
		Beer chosenBeer = beerDAO.findBeerById(beerId);
		List<FavoriteBeer> list = beerDAO.addBeerToFavList(chosenBeer, session);
		mv.addObject("message", "Added to Favorites");
		mv.addObject("beer", beerId);
		mv.addObject("list", list);
		mv.addObject("type", "fav");
		mv.setViewName("/WEB-INF/beerSearch.jsp");
		return mv;
	}

	@RequestMapping(path = "getFavorite.do")
	public ModelAndView getFavorite(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<FavoriteBeer> list = beerDAO.getListOfFavBeer(session);
		mv.addObject("list", list);
		mv.addObject("type", "fav");
		mv.setViewName("/WEB-INF/beerSearch.jsp");
		return mv;
	}

	@RequestMapping(path = "editProfile.do", method = RequestMethod.POST)
	public ModelAndView editProfile(Drinker drinker, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Drinker current = (Drinker) session.getAttribute("drinker");
		if(drinker.getDob() == null) {
			drinker.setDob(current.getDob());
		}
		drinker.setAddress(current.getAddress());
		drinker = userDAO.updateDrinker(drinker, current.getId());
		session.setAttribute("drinker", drinker);
		mv.setViewName("/WEB-INF/userProfile.jsp");
		return mv;
	}

	@RequestMapping(path = "editAddress.do", method = RequestMethod.POST)
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
		mv.addObject("styles", beerDAO.getStyles());
		mv.setViewName("/WEB-INF/userProfile.jsp");
		return mv;
	}

	@RequestMapping(path = "addBeerRequest.do", method = RequestMethod.POST)
	public ModelAndView addBeerRequest(Beer beer) {
		ModelAndView mv = new ModelAndView();
		beerDAO.createBeer(beer);
		mv.addObject("message", "Your submission has been recieved");
		mv.setViewName("/WEB-INF/userProfile.jsp");
		return mv;
	}
	@RequestMapping(path = "goToBeerRequest.do")
	public ModelAndView goToBeerRequest(Beer beer) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("type", "request");
		mv.setViewName("/WEB-INF/userProfile.jsp");
		return mv;
	}

	@RequestMapping(path = "removeBeerFav.do", method = RequestMethod.POST)
	public ModelAndView removeBeerFromFavs(HttpSession session, @RequestParam int favBeer) {
		ModelAndView mv = new ModelAndView();
		FavoriteBeer favoriteBeer = beerDAO.findFavBeerById(favBeer);
		beerDAO.removeBeerFromFavs(favoriteBeer, session);
		mv.addObject("type", "fav");
		List<FavoriteBeer> list = ((Drinker) session.getAttribute("drinker")).getBeers();
		mv.addObject("list", list);
		mv.setViewName("/WEB-INF/beerSearch.jsp");
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
			mv.addObject("styles", beerDAO.getStyles());
			session.setAttribute("user", uniqueUser);
			mv.setViewName("/WEB-INF/signup.jsp");
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
    @InitBinder("drinker")
    public void customizeBinding (WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "dob",
                                    new CustomDateEditor(dateFormatter, true));
    }

	@RequestMapping(path = "address.do", method = RequestMethod.POST)
	public ModelAndView addAddressToDrinker(Address address, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Drinker drinker = (Drinker) session.getAttribute("drinker");
		address = adDAO.createAddress(address);
		drinker.setAddress(address);
		userDAO.updateDrinker(drinker, drinker.getId());
		mv.addObject("user", session.getAttribute("user"));
		mv.setViewName("/WEB-INF/home.jsp");
		return mv;
	}

}
