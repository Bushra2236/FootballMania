package footballmania.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import footballmania.DataAO.ProdInterface;
import footballmania.DataAO.cartInterface;
import footballmania.DataAO.registerInterface;
import footballmania.Model.CartDetails;
import footballmania.Model.ProductModel;


@Controller
public class AddToCart {

@Autowired
ProductCont addPI;

@Autowired
ProdInterface prod;

@Autowired
CartDetails cart;

@Autowired
cartInterface catCI;

@Autowired
registerInterface addRM;


@RequestMapping(value="/add",method= RequestMethod.GET)
public ModelAndView addToCart(@RequestParam("prodId")String id){

ProductModel product= prod.fetchProduct(id);
cart.setPrice(product.getProdPrice());
cart.setProductName(product.getProdName());
cart.setStatus('N');

cart.setQuantity(1);
catCI.save(cart);

ModelAndView MnV =new ModelAndView("selectedProducts","comm", new CartDetails());
String display = catCI.displayCart();
MnV.addObject("cart",display);
return MnV;
}

@RequestMapping(value="/updateQuantity", method = RequestMethod.GET)
public ModelAndView updateQuantity(@RequestParam("cartId")String id, @RequestParam("quantity")int quant){
	
	catCI.update(id,quant);
	
	System.out.println(cart.getQuantity());
	
	String display = catCI.displayCart();
	ModelAndView MnV =new ModelAndView("selectedProducts","comm", new CartDetails());
	MnV.addObject("cart",display);
	return MnV;
}

}

