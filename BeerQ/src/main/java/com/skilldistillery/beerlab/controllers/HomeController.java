package com.skilldistillery.beerlab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.beerlab.entities.Bar;
import com.skilldistillery.beerlab.entities.Beer;

@Controller
public class HomeController {
	
	
	
	
	@RequestMapping(path = "barSearch.do")
	public ModelAndView barSearch(String keyword) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "barBrowse.do")
	public ModelAndView barBrowse() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "beerSearch.do")
	public ModelAndView beerSearch(String keyword) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "beerBrowse.do")
	public ModelAndView beerBrowse() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "getBeer.do")
	public ModelAndView getBeer(Beer beer) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@RequestMapping(path = "getBar.do")
	public ModelAndView getBar(Bar beer) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	

}
