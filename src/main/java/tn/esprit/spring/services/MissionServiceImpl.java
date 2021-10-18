package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.*;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements MissionService {
	@Autowired
	MissionRepository MissionRepository;

	private static final Logger l = LogManager.getLogger(MissionServiceImpl.class);
	
	
	@Override
	public List<Mission> retrieveAllMission() {
		List<Mission> Missions = null; 
		try {
	
			l.info("In retrieveAllMissions() : ");
			Missions = (List<Mission>) MissionRepository.findAll();  
			for (Mission Mission : Missions) {
				l.debug("Mission +++ : " + Mission);
			} 
			l.info("Out of retrieveAllMissions() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllMissions() : " + e);
		}

		return Missions;
	}

	@Override
	public Mission addMission(Mission m) {
		return MissionRepository.save(m); 
	}

	@Override
	public void deleteMission(String id) {
		MissionRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Mission updateMission(Mission m) {
		return MissionRepository.save(m); 
	}

	@Override
	public Mission retrieveMission(String id) {
		l.info("in  retrieveMission id = " + id);
		Mission d =  MissionRepository.findById(Long.parseLong(id)).get(); 
		l.info("Mission returned : " + d);
		return d; 
	}

	

}
