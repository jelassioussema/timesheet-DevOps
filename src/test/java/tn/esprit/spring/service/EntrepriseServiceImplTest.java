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
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {

	@Autowired
	EntrepriseServiceImpl en; 

	@Test
	public void testRetrieveAlllistEntreprises() {
		List<Entreprise> listEntreprises = en.retrieveAllEntreprises(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(15, listEntreprises.size());
	}
	
	
	@Test
	public void testAddEntreprise() throws ParseException {
		Entreprise e = new Entreprise("esprit", "université"); 
		Entreprise EntrepriseAdded = en.addEntreprise(e); 
		Assert.assertEquals(e.getName(), EntrepriseAdded.getName());
	}
 
	@Test
	public void testModifyUser() throws ParseException   {
		Entreprise e = new Entreprise( "esprit2", "université2"); 
		Entreprise entrepriseUpdated  = en.updateEntreprise(e); 
		Assert.assertEquals(e.getName(), entrepriseUpdated.getName());
	}

	@Test
	public void testRetrieveUser() {
		Entreprise entrepriseRetrieved = en.retrieveEntreprise("1"); 
		Assert.assertEquals(1L, entrepriseRetrieved.getId());
	}
	
	@Test
	public void testDeleteEntreprise() {
		en.deleteEntreprise("1");
		Assert.assertNull(en.retrieveEntreprise("1"));
	}
	
	// 5 tests unitaires  

}
