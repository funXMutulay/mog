package org.nioun.essentials.mog.service;

import java.util.List;

import org.nioun.essentials.mog.model.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

     List<Product> findAll();

     Product getProduct(Integer id);

     //Product save(Product Product);

     // void saveProductToDB(MultipartFile file , 
     //                     String nom , String style ,
     //                     Integer prix  , Integer stocks );


     Product saveProduct(Product product);

     Product updateProduct (int id);

     void deleteProduct (int id);


}
