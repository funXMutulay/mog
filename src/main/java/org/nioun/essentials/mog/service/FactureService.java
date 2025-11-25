package org.nioun.essentials.mog.service;

import java.util.List;
import java.util.Optional;

import org.nioun.essentials.mog.model.Facture;


public interface FactureService {

     List<Facture> findAll();

     Optional<Facture> findById(int id);

     void delete(int id);

     void save(Facture facture);
	

}
