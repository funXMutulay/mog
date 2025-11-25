package org.nioun.essentials.mog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import org.nioun.essentials.mog.model.Product;
import org.nioun.essentials.mog.model.Categorie;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

   

    @Query(nativeQuery = true, value = "SELECT * FROM product WHERE categorie = :#{#categorie?.label()}")
List<Product> getByCategorie(@Param("categorie") Categorie categorie);

 @Query(value = "SELECT * FROM product WHERE categorie = ?1", nativeQuery = true)
    List<Product> findByCategorie(String categorie);

}
