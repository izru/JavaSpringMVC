package com.ipartek.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/saludo", method = RequestMethod.GET)
	public String saludar(Model model) {
		model.addAttribute("nombre", "Mariani" );
		return "saludo"; // devuelve el nombre de la vista
	}
	
	@RequestMapping(value = "/saludo2", method = RequestMethod.GET)
	public ModelAndView saludar2 (Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("nombre", "Mari2");
		mv.setViewName("saludo");
		return mv;// devuelve el modelo y la vista
	}
	
	@RequestMapping(value = "/saludo3/{nombre}/{numero}", method = RequestMethod.GET)
	public String saludar3 (Model model, @PathVariable String nombre, @PathVariable  int numero) {
		model.addAttribute("nombre", nombre +  " " + numero );
		return "saludo";// devuelve el modelo y la vista
	}// pasa 2 parametros y los convierte a lo que tenga que ser
	
	@RequestMapping(value = "/saludo60", method = RequestMethod.GET)
	public String saludar60(Model model, HttpServletRequest request, HttpSession sesion) {
		model.addAttribute("nombre", "Mariani" );
		return "saludo"; // devuelve el nombre de la vista
	}
	
}
