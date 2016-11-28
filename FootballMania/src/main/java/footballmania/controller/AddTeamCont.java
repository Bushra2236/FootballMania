package footballmania.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import footballmania.DataAO.addTeamInterface;
import footballmania.Model.addTeamModel;

@Controller
public class AddTeamCont {

	@Autowired
	addTeamInterface addTI;
	
	@RequestMapping(value = "/AddTeam", method = RequestMethod.GET)
	   public ModelAndView reg() {
		addTeamModel tm= new addTeamModel();
		String newId= addTI.generateTeamId();
		tm.setTeamId(newId);
		String teamData = addTI.displayTeam();
		ModelAndView MnV = new ModelAndView("AddTeam","command", tm);
		MnV.addObject("TeamList",teamData);
		return MnV;
	   }
	
	
	@RequestMapping(value = "/addTeam", method = RequestMethod.POST)
	   public ModelAndView addTeam(addTeamModel team) 
	{
		
		String newID = addTI.generateTeamId();
		team.setTeamId(newID);
		addTI.addTeam(team);
	    ModelAndView MnV = new ModelAndView("AddTeam","command", new addTeamModel());
		String path="C:\\Project\\FootballMania\\src\\main\\webapp\\resources\\";
		path=path+String.valueOf(team.getTeamId())+".jpg";
		File f=new File(path);
		MultipartFile filedet= team.getTeamImage();
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
				
		//adding teams
		String teamData = addTI.displayTeam();
		MnV.addObject("TeamList",teamData);
		return MnV;
	   }
	
	
	@RequestMapping(value="/fetchTeam", method=RequestMethod.GET)
	public ModelAndView updateTeam (@RequestParam("teamId") String id){
	addTeamModel adt = addTI.fetchTeam(id);
	ModelAndView MnV= new ModelAndView ("AddTeam","command",adt);
	String teamData = addTI.displayTeam();
	MnV.addObject("TeamList", teamData);
	MnV.addObject("updateClicked",true);
	
	return MnV;
	
	}
	
	@RequestMapping(value="/updateTeamtoDB", method= RequestMethod.POST)
	public ModelAndView updateTeamDB(addTeamModel team)
	{
		addTI.updateTeam(team);
		ModelAndView MnV = new ModelAndView("AddTeam","command", new addTeamModel());
		String newID = addTI.generateTeamId();
		team.setTeamId(newID);
		String teamData=addTI.displayTeam();
		MnV.addObject("TeamList", teamData);
		return MnV;
	}
	
	@RequestMapping (value="deleteTeam", method= RequestMethod.GET)
	public ModelAndView deleteTeam(@RequestParam("teamId")String id)
	{
		addTeamModel team =new addTeamModel();
		String newID = addTI.generateTeamId();
		team.setTeamId(newID);
	ModelAndView MnV =new ModelAndView("AddTeam","command", new addTeamModel());
	addTI.deleteTeam(id);
	String teamData =addTI.displayTeam();
	MnV.addObject("TeamList",teamData);
	return MnV;
	}
	
}
