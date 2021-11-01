package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.MissionExterne;
import tn.esprit.spring.repository.MissionExterneRepository;

@Service
public class MissionExterneServiceImpl implements MissionExterneService {
	@Autowired
	MissionExterneRepository MissionExterneRepository;

	private static final Logger l = LogManager.getLogger(MissionExterneServiceImpl.class);
	
	
	@Override
	public List<MissionExterne> retrieveAllMissionExterne() {
		List<MissionExterne> MissionExternes = null; 
		try {
	
			l.info("In retrieveAllMissionExternes() : ");
			MissionExternes = (List<MissionExterne>) MissionExterneRepository.findAll();  
			for (MissionExterne MissionExterne : MissionExternes) {
				l.debug("MissionExterne +++ : " + MissionExterne);
			} 
			l.info("Out of retrieveAllMissionExternes() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllMissionExternes() : " + e);
		}

		return MissionExternes;
	}

	@Override
	public MissionExterne addMissionExterne(MissionExterne m) {
		return MissionExterneRepository.save(m); 
	}

	@Override
	public void deleteMissionExterne(String id) {
		MissionExterneRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public MissionExterne updateMissionExterne(MissionExterne m) {
		return MissionExterneRepository.save(m); 
	}

	@Override
	public MissionExterne retrieveMissionExterne(String id) {
		l.info("in  retrieveMissionExterne id = " + id);
		MissionExterne d =  MissionExterneRepository.findById(Long.parseLong(id)).orElse(null); 
		l.info("MissionExterne returned : " + d);
		return d; 
	}

	

}
