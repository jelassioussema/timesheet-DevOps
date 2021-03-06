package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {

	List<Entreprise> retrieveAllEntreprises(); 
	Entreprise addEntreprise(Entreprise e);
	void deleteEntreprise(String id);
	Entreprise updateEntreprise(Entreprise d);
	Entreprise retrieveEntreprise(String id);
}
