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
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.MissionService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	@Autowired
	MissionService m; 

	@Test
	public void testRetrieveAllMissions() {
		List<Mission> listMissions = m.retrieveAllMission(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(15, listMissions.size());
	}
	
	
	@Test
	public void testAddMission() throws ParseException {

		Departement d= new Departement("depart 1");
	
		Mission mi = new Mission("projet 1","premier projet",d); 
		Mission MissionAdded = m.addMission(mi); 
		Assert.assertEquals(mi.getName(), MissionAdded.getName());
	}
 
	@Test
	public void testModifyMission() throws ParseException   {
		Mission mi = new Mission("new Project"); 
		Mission MissionUpdated  = m.updateMission(mi); 
		Assert.assertEquals(mi.getName(), MissionUpdated.getName());
	}

	@Test
	public void testRetrieveMission() {
		Mission MissionRetrieved = m.retrieveMission("1"); 
		Assert.assertEquals(1L, MissionRetrieved.getId());
	}
	
	@Test
	public void testDeleteMission() {
		m.deleteMission("3");
		Assert.assertNull(m.retrieveMission("3"));
	}
	
	// 5 tests unitaires  


}
