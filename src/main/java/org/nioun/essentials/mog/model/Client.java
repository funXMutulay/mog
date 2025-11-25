package org.nioun.essentials.mog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Transient;
import java.util.List;

@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client{
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer id;

    private String nom;
	
	private String prenom;
    
   
    private String email;
	
    private String telephone;
    
    private String photo ;
    
    @OneToMany(targetEntity=Product.class,cascade=CascadeType.ALL)
    @JoinColumn(name="cp_fk" , referencedColumnName="id")
    private List<Product> Products;

    @Transient
    private String photosPath;

    public String getPhotosPath(){
    
        if(id == null || photo == null){
        return "assets/img/user.png";
    }

        return "customer-photos/"+this.id+"/"+this.photo;
    }
}
