package org.nioun.essentials.mog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.nioun.essentials.mog.model.Client;
import org.nioun.essentials.mog.dto.OrderResponse; 
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>{

    @Query("SELECT  new org.nioun.essentials.mog.dto.OrderResponse(c.nom , p.descriptif) FROM Client c JOIN c.Products p ")
    public  List<OrderResponse> getJointInformation();

}
