package org.nioun.essentials.mog.handler;

import org.nioun.essentials.mog.model.Product;
import org.nioun.essentials.mog.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryHandler {

    private final ProductRepository productRepository;

    public InventoryHandler(ProductRepository productRepository){this.productRepository = productRepository;}

    public Product updateProductDetails(Product product){
        if(product.getPrix() > 5000){
            throw new RuntimeException(" BDFL on cockpit ... ") ;
        }

        return productRepository.save(product);
    }

    public Product getProduct(Integer id){
        return productRepository.getById(id);
                            /* .orElseThrow(
                                () -> new RuntimeException("Produit introuvable")
                            ); */
    }

    
}
