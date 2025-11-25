package org.nioun.essentials.mog.handler;

import org.nioun.essentials.mog.model.Product;
import org.nioun.essentials.mog.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryHandler {

    private final ProductRepository ProductRepository;

    public InventoryHandler(ProductRepository ProductRepository){this.ProductRepository = ProductRepository;}

    public Product updateProductDetails(Product Product){
        if(Product.getPrix()>5000){
            throw new RuntimeException(" BDFL on cockpit ... ") ;
        }

        return ProductRepository.save(Product);
    }

    public Product getProduct(Integer id){
        return ProductRepository.findById(id)
                            .orElseThrow(
                                () -> new RuntimeException("Produit introuvable")
                            );
    }

    
}
