


package footballmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import footballmania.DataAO.SupplierInterface;

import footballmania.Model.SupplierModel;

@Controller
public class SupplierCont {

@Autowired
SupplierInterface addSI;


@RequestMapping(value = "/ManageSupp", method = RequestMethod.GET)
public ModelAndView regi() {

	SupplierModel supplier =  new SupplierModel();
	String newId = addSI.generateSuppId();
	supplier.setSupplierId(newId);

	String suppData = addSI.displaySupplier();
	ModelAndView MnV = new ModelAndView("ManageSupp","command", supplier);
	
	MnV.addObject("SuppList",suppData);
	return MnV;
}



@RequestMapping(value = "/addSupp", method = RequestMethod.POST)
public ModelAndView addSupp(SupplierModel supplier) 
{
	String newId = addSI.generateSuppId();
	supplier.setSupplierId(newId);

	ModelAndView MnV = new ModelAndView("ManageSupp","command", supplier);
	addSI.addSupplier(supplier);
	String suppData = addSI.displaySupplier();
	MnV.addObject("SuppList",suppData);
	
	return MnV;
}

@RequestMapping(value="/fetchSupplier", method=RequestMethod.GET)
public ModelAndView updateSupp (@RequestParam("supplierId") String id){
SupplierModel sdt = addSI.fetchSupplier(id);
ModelAndView MnV= new ModelAndView ("ManageSupp","command",sdt);
String suppData = addSI.displaySupplier();
MnV.addObject("SuppList", suppData);
MnV.addObject("updateClicked",true);
return MnV;

}

@RequestMapping(value="/updateSupptoDB", method= RequestMethod.POST)
public ModelAndView updateSuppDB(SupplierModel supplier)
{
	
	addSI.updateSupplier(supplier);
	ModelAndView MnV = new ModelAndView("ManageSupp","command", supplier);
	String suppData=addSI.displaySupplier();
	MnV.addObject("SuppList", suppData);
	//String newId = addSI.generateSuppId();
	//supplier.setSupplierId(newId);
	return MnV;
}

@RequestMapping (value="deleteSupplier", method= RequestMethod.GET)
public ModelAndView deleteSupp(@RequestParam("supplierId")String id)
{
	SupplierModel supplier =new SupplierModel();
	String newId = addSI.generateSuppId();
	supplier.setSupplierId(newId);
	ModelAndView MnV =new ModelAndView("ManageSupp","command", supplier);
	addSI.deleteSupplier(id);
	String suppData =addSI.displaySupplier();
	MnV.addObject("SuppList",suppData);
	return MnV;
}
}