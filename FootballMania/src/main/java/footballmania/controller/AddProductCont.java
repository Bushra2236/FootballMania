package footballmania.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import footballmania.DataAO.addProdInterface;
import footballmania.Model.addProductModel;



@Controller
public class AddProductCont {

@Autowired 
addProdInterface addPI;

@RequestMapping(value = "/AddProd", method = RequestMethod.GET)
public ModelAndView regi() {
	

	addProductModel product =  new addProductModel();
	String newId = addPI.generateProdId();
	product.setProdId(newId);
	
	String prodData = addPI.displayProduct();
	ModelAndView MnV = new ModelAndView("AddProd","command", product);
	MnV.addObject("ProdList",prodData);
	
	String catData = addPI.displayCategory();
	MnV.addObject("CategoryList",catData);

	String suppData =addPI.displaySupplier();
	MnV.addObject("SuppList",suppData);
	return MnV;
}



@RequestMapping(value = "/addProd", method = RequestMethod.POST)
public ModelAndView addProd(addProductModel product) 
{
	
	
	addPI.addProd(product);
	ModelAndView MnV = new ModelAndView("AddProd","command", product);
	String path="C:\\Project\\FootballMania\\src\\main\\webapp\\resources\\";
	path=path+String.valueOf(product.getProdId())+".jpg";
	File f =new File(path);
	
	MultipartFile filedet= product.getProdImage();
			if(!filedet.isEmpty())
{
				try
				{
					byte[] bytes=filedet.getBytes();
					FileOutputStream fos=new FileOutputStream(f);
					BufferedOutputStream bs=new BufferedOutputStream(fos);
					bs.write(bytes);
					bs.close();
					System.out.println("File Uploaded Successfully");
				}
				catch(Exception e)
				{
					System.out.println("Exception Arised"+e);
				}
}
			else
		{
				System.out.println("File is Empty not Uploaded");
		}
			String newId = addPI.generateProdId();
			product.setProdId(newId);		
	//adding products
	String prodData = addPI.displayProduct();
	MnV.addObject("ProdList",prodData);
	String catData = addPI.displayCategory();
	MnV.addObject("CategoryList",catData);
	String suppData =addPI.displaySupplier();
	MnV.addObject("SuppList",suppData);
	return MnV;
}


@RequestMapping(value="/fetchProduct", method=RequestMethod.GET)
public ModelAndView updateProduct (@RequestParam("prodId") String id){
addProductModel pdt = addPI.fetchProduct(id);
ModelAndView MnV= new ModelAndView ("AddProd","command",pdt);

String prodData = addPI.displayProduct();
MnV.addObject("ProdList", prodData);

String catData = addPI.displayCategory();
MnV.addObject("CategoryList",catData);

String suppData =addPI.displaySupplier();
MnV.addObject("SuppList",suppData);


MnV.addObject("updateClicked",true);
return MnV;

}


@RequestMapping(value="/updateProdtoDB", method= RequestMethod.POST)
public ModelAndView updateProdDB(addProductModel product)
{
	addPI.updateProduct(product);
	String newId = addPI.generateProdId();
	addProductModel addprod=new addProductModel();
	
	addprod.setProdId(newId);
	ModelAndView MnV = new ModelAndView("AddProd","command", addprod);
	String prodData=addPI.displayProduct();
	MnV.addObject("ProdList", prodData);
	
	String catData = addPI.displayCategory();
	MnV.addObject("CategoryList",catData);

	String suppData =addPI.displaySupplier();
	MnV.addObject("SuppList",suppData);
	return MnV;
}

@RequestMapping (value="deleteProduct", method= RequestMethod.GET)
public ModelAndView deleteProd(@RequestParam("prodId")String id)
{
addProductModel product = new addProductModel();

ModelAndView MnV =new ModelAndView("AddProd","command", product);
addPI.deleteProduct(id);

String newId = addPI.generateProdId();
product.setProdId(newId);

String prodData =addPI.displayProduct();
MnV.addObject("ProdList",prodData);

String catData = addPI.displayCategory();
MnV.addObject("CategoryList",catData);

String suppData =addPI.displaySupplier();
MnV.addObject("SuppList",suppData);
return MnV;
}
}
