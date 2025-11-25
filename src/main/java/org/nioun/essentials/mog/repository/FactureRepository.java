package org.nioun.essentials.mog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.nioun.essentials.mog.model.Facture;


@Repository
public interface FactureRepository extends JpaRepository<Facture,Integer>{

}
