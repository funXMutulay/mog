package org.nioun.essentials.mog.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.Data;

@Data
@Entity
// @Getter
// @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product{
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private String nom;
	private String descriptif;
    private String label;
    
    @Enumerated(EnumType.STRING)
    private Categorie categorie;	
	private Integer prix;
	private Integer stocks;
    private String image;
    
    @Transient
    private String imagesPath;

    /**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public String getDescriptif(){
        return descriptif;
    }
    public void setDescriptif(String descriptif){
        this.descriptif=descriptif;
    }

    public String getLabel(String label){
        return label;}

        
    public void setLabel(String label){
        this.label=label;
    }
        /**
	 * @return the prix
	 */
	public Integer getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(Integer prix) {
		this.prix = prix;
	}


	public Integer getStocks() {
		return stocks;
	}

	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}

    public void setImage(String image){
        this.image=image;
    }
    
    public String getImagesPath(){

        if (id == null || image == null){
            return "assets/img/apachChach.png"; 
        }
        return "product-photos/"+this.id+"/"+this.image ;
    }

    

}
