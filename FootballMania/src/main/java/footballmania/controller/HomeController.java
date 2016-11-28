package footballmania.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import footballmania.Model.registerModel;

@Controller
public class HomeController 
{
@RequestMapping( value="/home", method= RequestMethod.GET)

	public ModelAndView home(){

	ModelAndView MnV = new ModelAndView("home","commands",new registerModel());
	return MnV;
	}
	
@RequestMapping ("/contactus")
	public ModelAndView contact(){
	ModelAndView MnV = new ModelAndView("contactus","commands",new registerModel());
	return MnV;
}

@RequestMapping("/adminPanel")
	public ModelAndView adminPanel(){
	ModelAndView MnV = new ModelAndView("adminPanel","commands",new registerModel());
	return MnV;
}

}
