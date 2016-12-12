package footballmania.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import footballmania.DataAO.CategoryInterface;
import footballmania.DataAO.ProdInterface;
import footballmania.DataAO.registerInterface;
import footballmania.DataAO.userCredInterface;
import footballmania.Model.registerModel;
import footballmania.Model.userCredModel;

@Controller
public class RegisterCont {

@Autowired
registerInterface addRM;

@Autowired
userCredInterface user;

@Autowired
CategoryInterface category;

@Autowired
ProdInterface product;

@RequestMapping("/")
public ModelAndView newPage(HttpSession session){
	
	String cat = category.displayCat();
	ModelAndView MnV = new ModelAndView("index","commands", new registerModel());
	session.setAttribute("catList",cat);
	return MnV;
}


@RequestMapping(value="/registerUser",method= RequestMethod.POST)
public ModelAndView registerUser(registerModel reg){
	
	addRM.registerUser(reg);
	ModelAndView MnV = new ModelAndView("index","commands",new registerModel());
	userCredModel ucm = new userCredModel();
	ucm.setUserName(reg.getUserId());
	ucm.setPassword(reg.getUserPassword());
	ucm.setRole("ROLE_USER");
	ucm.setEnabled(true);
	user.addUserCred(ucm);
	return MnV;
}

@RequestMapping(value="/fetchProducts",method= RequestMethod.GET)
public ModelAndView displayProducts(@RequestParam("catId") String id)
{
	
	String display= addRM.fetchProducts(id);
	
	ModelAndView MnV= new ModelAndView("DisplayProducts","commands", new registerModel());
	
	MnV.addObject("displayProd",display);
	return MnV;
}

@RequestMapping(value="/fetchTeams", method= RequestMethod.GET)
public ModelAndView teams(){

	String team = addRM.fetchTeams();
	ModelAndView MnV = new ModelAndView ("teams","commands", new registerModel());
	MnV.addObject("display",team);
	return MnV;
}

}

