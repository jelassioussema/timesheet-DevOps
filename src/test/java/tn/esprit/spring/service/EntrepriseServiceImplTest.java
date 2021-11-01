package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IEntrepriseService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService en;
	
	/*@Test
	public void testRetrieveAllEntreprises() {
		List<Entreprise> listEntreprises = en.retrieveAllEntreprises(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(9, listEntreprises.size());
	}*/
	@Test
	public void testAddEntreprise() throws ParseException {
		Entreprise e = new Entreprise("esprit", "univ"); 
		Entreprise entrepriseAdded = en.addEntreprise(e); 
		Assert.assertEquals(e.getName(), entrepriseAdded.getName());
	}
	
	/*@Test
	public void testModifyEntreprise() throws ParseException   {
		Entreprise e = new Entreprise(1L,"esprit1", "univ1"); 
		Entreprise entrepriseUpdated  = en.updateEntreprise(e); 
		Assert.assertEquals(e.getName(), entrepriseUpdated.getName());
	}
	@Test
	public void testRetrieveEntreprise() {
		Entreprise entrepriseRetrieved = en.retrieveEntreprise("1"); 
		Assert.assertEquals(1L, entrepriseRetrieved.getId());
	}
	@Test
	public void testDeleteEntreprise() {
		en.deleteEntreprise("17");
		Assert.assertNull(en.retrieveEntreprise("3"));
	}*/
}

