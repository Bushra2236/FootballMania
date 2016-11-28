package footballmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import footballmania.DataAO.addCategoryInterface;
import footballmania.Model.addCategoryModel;



@Controller
public class addCategoryCont {

@Autowired
addCategoryInterface addCI;

@RequestMapping(value = "/AddCat", method = RequestMethod.GET)
public ModelAndView regi() {
	
	addCategoryModel category =  new addCategoryModel();
	String newId = addCI.generateCatId();
	category.setCatId(newId);
	String catData = addCI.displayCat();
	ModelAndView MnV = new ModelAndView("AddCat","command", category);
	MnV.addObject("CatList",catData);
	return MnV;
}


@RequestMapping(value = "/addCat", method = RequestMethod.POST)
public ModelAndView addCat(addCategoryModel category) 
{
	String newId = addCI.generateCatId();
	category.setCatId(newId);
	
	ModelAndView MnV = new ModelAndView("AddCat","command", category);
	addCI.addCat(category);
	String catData = addCI.displayCat();
	MnV.addObject("CatList",catData);
	return MnV;
}


@RequestMapping(value="/fetchCategory", method=RequestMethod.GET)
public ModelAndView updateCat (@RequestParam("catId") String id){
	
	
addCategoryModel cdt = addCI.fetchCat(id);
ModelAndView MnV= new ModelAndView ("AddCat","command",cdt);
String catData = addCI.displayCat();
MnV.addObject("CatList", catData);
MnV.addObject("updateClicked",true);
return MnV;

}


@RequestMapping(value="/updateCattoDB", method= RequestMethod.POST)
public ModelAndView updateCatDB(addCategoryModel category)
{
	
	addCI.updateCat(category);
	ModelAndView MnV = new ModelAndView("AddCat","command", category);
	String catData= addCI.displayCat();
	MnV.addObject("CatList", catData);
	String newId = addCI.generateCatId();
	category.setCatId(newId);
	return MnV;
}

@RequestMapping (value="deleteCategory", method= RequestMethod.GET)
public ModelAndView deleteCat(@RequestParam("catId")String id)
{
	addCategoryModel category = new addCategoryModel();
	
	ModelAndView MnV =new ModelAndView("AddCat","command", category);
	addCI.deleteCat(id);
	String catData =addCI.displayCat();
	String newId = addCI.generateCatId();
	category.setCatId(newId);
	MnV.addObject("CatList",catData);
	return MnV;
}

}
