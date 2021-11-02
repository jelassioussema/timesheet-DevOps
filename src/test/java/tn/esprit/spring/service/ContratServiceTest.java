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

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.ContratService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceTest {
	@Autowired
	ContratService     Cu;
	private static final Logger l = LogManager.getLogger(ContratServiceTest.class);
	
	@Test
	public void testRetrieveAllContart() {
		List<Contrat> listContrat = Cu.retrieveAllContrat(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(2, listContrat.size());
	}
	
	
	
	@Test
	public void testAddContrat() throws ParseException
	
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c = new Contrat(d,"cdi",1200);
	    Contrat	Contratadded =Cu.addContrat(c);
		l.info("Ajout avec Succés !! ");
		Assert.assertEquals(c.getTypeContrat(), Contratadded.getTypeContrat());
	}
	
	
	@Test
	public void testModifyContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c = new Contrat(4L,d,"Stage", 1500) ;
		Contrat contratUpdated  = Cu.UpdateContrat(c); 
		Assert.assertEquals(c.getTypeContrat(), contratUpdated.getTypeContrat());
		
	}
	
	@Test
	public void testRetrieveUser() {
		Contrat contratRetrieved = Cu.retrieveContrat("1"); 
		Assert.assertEquals(1L, contratRetrieved.getId().longValue());
	}
		
	@Test
	public void testDeleteContrat() {
		Cu.deleteContrat("5");
//		Assert.assertNull(Cu.retrieveContrat("45"));
	}
	

}
