package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.MissionService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	@Autowired
	MissionService m; 

	
	
	
	@Test
	public void testAddMission() throws ParseException {
		Mission mi = new Mission("prrrroject"); 
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
		Mission MissionRetrieved = m.retrieveMission("65"); 
		Assert.assertEquals(65, MissionRetrieved.getId());
	}
	
	
	
	// 5 tests unitaires  


}
