package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;


public interface MissionService {
	List<Mission> retrieveAllMission(); 
	Mission addMission(Mission m);
	void deleteMission(String id);
	Mission updateMission(Mission m);
	Mission retrieveMission(String id);

}
