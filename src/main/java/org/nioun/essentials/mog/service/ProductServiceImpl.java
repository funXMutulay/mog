
package org.nioun.essentials.mog.service;

import java.util.List;
import java.util.Base64;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;


import org.nioun.essentials.mog.model.Product;
import org.nioun.essentials.mog.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    ProductRepository productRepository;

    
    public ProductRepository getProductRepository() {
        return productRepository;
    }



    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
   public  List<Product>  findAll(){
        return productRepository.findAll();
    }


    // Ceuillir , querir une product 
    public Product getProduct(Integer id){
        return productRepository.getById(id);
    }

    
    // save object with RequestParam forEach attribute rather than as a bundle m for o;plexity handling 
    //  public void  saveProductToDB ( MultipartFile file , 
    //                      String nom , String style ,
    //                      Integer prix , Integer stocks ){

    //         Product t = new Product();
    //         String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    //             if (fileName.contains("..")){
    //                 System.out.println("not a valid file");
    //             } try{
    //                 t.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
    //             }catch(IOException e){
    //                 e.printStackTrace();
    //             }

    //                 t.setNom(nom);
    //                 t.setStyle(style);
    //                 t.setPrix(prix);
    //                 t.setStocks(stocks);
    //                 ProductRepository.save(t);
    //  }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }


        
        public Product updateProduct (int id){
        Product productUpdt=productRepository.getById(id);
        return productRepository.save(productUpdt);
      };

     @Override
     public void deleteProduct (int id){
        productRepository.deleteById(id);
     };

}
