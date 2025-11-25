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
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product{
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
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


    public String getImagesPath(){

        if (id == null || image == null){
            return "assets/img/apachChach.png"; 
        }
        return "product-photos/"+this.id+"/"+this.image ;
    }
}
