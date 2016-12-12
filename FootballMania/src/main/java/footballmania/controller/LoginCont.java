package footballmania.controller;





import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import footballmania.Model.userCredModel;


@Controller
public class LoginCont {

	@RequestMapping(value="/Login", method=RequestMethod.GET)
	 public ModelAndView LoginForm(userCredModel user){
		ModelAndView MnV = new ModelAndView("Login");
		return MnV;
	 }
	@RequestMapping(value="/adminPanelView")
	public String userView(HttpSession session, Model model){
		
		String username= SecurityContextHolder.getContext().getAuthentication().getName();
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = 
		(Collection<GrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		String role="ROLE_USER";
		
		for(GrantedAuthority authority:authorities){
			if(authority.getAuthority().equals(role)){
				session.setAttribute("UserLoggedIn", true);
				session.setAttribute("user", "Welcome" + username);
				page="home";
				}
			else{
				session.setAttribute("Admin", true);
				session.setAttribute("user", "Welcome" + username);
				page="adminPanel";
			}
		}
		return page;
	}
	/*@RequestMapping(value="/LoginError", method=RequestMethod.GET)
	public ModelAndView LoginError(userCredModel user){
		ModelAndView MnV = new ModelAndView("Login","logs", new userCredModel());
	MnV.addObject("ErrorMessage", "Please enter valid Username and Password!");
		return MnV;
	}*/	
}
