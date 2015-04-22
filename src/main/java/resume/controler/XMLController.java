package resume.controler;


import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import resume.modele.CompetenceInfo;
import resume.modele.Cv;
import resume.modele.Experiencepro;
import resume.modele.Langue;
import resume.modele.Listcvs;
import resume.modele.Scolarite;

@Controller
@RequestMapping("/cv")
public class XMLController {
	HashMap<Integer, Cv> listdescvs = new HashMap<Integer, Cv>();
	Listcvs listcvs = new Listcvs();
	LinkedList<Experiencepro> Experience_profesionelle = new LinkedList<Experiencepro>()  ;
	LinkedList<Langue> Langues =new LinkedList<Langue>();
	LinkedList<Scolarite> Scolarites =new LinkedList<Scolarite>();
	LinkedList<CompetenceInfo> Competences_informatique=new LinkedList<CompetenceInfo>();
	public XMLController()
	{//CV1
		Experiencepro E = new Experiencepro();
		E.setTitre("Dev");
		E.setDescription("Android");
		for(int i=0;i<3;i++)
		{
			Experience_profesionelle.add(E);
		}
		Langue L= new Langue();
		L.setTitre("français");
		L.setNiveau(5);
		for(int i=0;i<3;i++)
		{
			Langues.add(L);
		}
		Scolarite s = new Scolarite();
		s.setTitre("Univ Rouen");
		s.setDescription("M1 GIL");
		Scolarites.add(s);
		CompetenceInfo C= new CompetenceInfo();
		C.setType("JEE");
		C.setNiveau(5);
		Competences_informatique.add(C);
		Cv Cv = new Cv("Rahil","Yanis","Chef De Projet",Experience_profesionelle,
				Scolarites,Langues,Competences_informatique);
		//CV2
		Experiencepro E2 = new Experiencepro();
		E.setTitre("Dev");
		E.setDescription("STRRRRRR");
		for(int i=0;i<3;i++)
		{
			Experience_profesionelle.add(E);
		}
		Langue L2= new Langue();
		L2.setTitre("français");
		L2.setNiveau(5);
		for(int i=0;i<3;i++)
		{
			Langues.add(L);
		}
		Scolarite s2 = new Scolarite();
		s2.setTitre("Univ Rouen");
		s2.setDescription("M1 GIL");
		Scolarites.add(s2);
		CompetenceInfo C2= new CompetenceInfo();
		C2.setType("JEE");
		C2.setNiveau(5);
		Competences_informatique.add(C);
		Cv Cv2 = new Cv("Jean","Luc","Manager",Experience_profesionelle,
				Scolarites,Langues,Competences_informatique);
		listdescvs.put(1, Cv);
		listdescvs.put(2, Cv2);
		listcvs.setCvs(listdescvs);

	}


	@RequestMapping(value="", method = RequestMethod.GET)
	public @ResponseBody Listcvs getCVsInXML(  ) {
		return listcvs;
	}

	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Cv getCVInXML(@PathVariable int id ) {

		return listcvs.getCvs().get(id);

	}  



	@RequestMapping(method=RequestMethod.POST, value="/addCv")
	public @ResponseBody void postCv(@RequestBody Cv cv) {
		listdescvs.put(listdescvs.size()+1, cv);
		listcvs.setCvs(listdescvs);

	}

}