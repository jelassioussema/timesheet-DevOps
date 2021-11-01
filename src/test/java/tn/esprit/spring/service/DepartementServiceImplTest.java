package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {
	@Autowired
	IDepartementService ds; 

	/*@Test
	public void testRetrieveAllDepartements() {
		List<Departement> listDepartements = ds.retrieveAllDepartements(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(10, listDepartements.size());
	}
	*/
	
	@Test
	public void testAddDepartement() throws ParseException {
		Departement d = new Departement("IT"); 
		Departement departementAdded = ds.addDepartement(d); 
		Assert.assertEquals(d.getName(), departementAdded.getName());
	}
 
	@Test
	public void testModifyDepartement() throws ParseException   {
		Departement d = new Departement("Finance"); 
		Departement departementUpdated  = ds.updateDepartement(d); 
		Assert.assertEquals(d.getName(), departementUpdated.getName());
	}

	/*@Test
	public void testRetrieveDepartement() {
		Departement departementRetrieved = ds.retrieveDepartement("1"); 
		Assert.assertEquals(1L, departementRetrieved.getId());
	}
	
	@Test
	public void testDeleteDepartement() {
		ds.deleteDepartement("3");
		Assert.assertNull(ds.retrieveDepartement("3"));
	}
	
	// 5 tests unitaires  
*/

}
