package org.nioun.essentials.mog.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Facture{
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFacture;

    private String client;
	
    private String status;	
	
    private Integer montant;
	
    private String remarques;	
    
    
    Facture (){

    }
}
