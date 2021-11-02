package tn.esprit.spring.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;

import tn.esprit.spring.repository.ContratRepository;



@Service
public class ContratServiceImpl implements ContratService {
	
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	@Autowired
	ContratRepository Cr;
	@Override
	public Contrat addContrat(Contrat c) {
		// TODO Auto-generated method stub
		
		return Cr.save(c);
       
		
	}

	
	@Override
	public void deleteContrat(String id) {
		// TODO Auto-generated method stub
		Cr.deleteById(Long.parseLong(id));
		
	}


	@Override
	public List<Contrat> retrieveAllContrat() {
		// TODO Auto-generated method stub
		List<Contrat> contrats = null; 
		try {
	
			l.info("In retrieveAllContrats : ");
			contrats = (List<Contrat>) Cr.findAll();  
			for (Contrat contrat: contrats) {
				l.debug("user +++ : " + contrat);
			} 
			l.info("Out of retrieveAllContrats : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllContrats : " + e);
		}

		return contrats;
	}

	@Override
	public Contrat UpdateContrat(Contrat c) {
		// TODO Auto-generated method stub
		return Cr.save(c);
	}


	@Override
	public Contrat retrieveContrat(String id) {
		// TODO Auto-generated method stub
		l.info("in  retrieveContrat id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		Contrat c =  Cr.findById(Long.parseLong(id)).orElse(null);
		l.info("user returned : " + c);
		return c; 
	}
	
	
	

}
