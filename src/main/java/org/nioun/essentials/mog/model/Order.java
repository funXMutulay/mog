package org.nioun.essentials.mog.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
@Entity
public class Order{
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idProduct;
    private Integer prixTotal;
	private Integer quantite;	

   

    public Integer getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public Integer getIdProduct(){
        return idProduct;
    }
    public void setIdProduct(int idProduct){
        this.idProduct=idProduct;
    }

    public Integer getPrixTotal(){
        return prixTotal;
    }
    public void setPrixTotal(int prixTotal){
        this.prixTotal=prixTotal;
    }

    public Integer getQuantite(){
        return quantite;
    }
    public void setQuantite(int quantite){
        this.quantite=quantite;
    }
    
    

}
