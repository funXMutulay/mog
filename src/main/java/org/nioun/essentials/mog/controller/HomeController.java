package org.nioun.essentials.mog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;

import org.nioun.essentials.mog.model.Product;
import org.nioun.essentials.mog.repository.ProductRepository;
import org.nioun.essentials.mog.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins="*" , maxAge=3600)
public class HomeController {

//      @Autowired
//     public ProductService service;

//      @Autowired
//     public static ProductRepository repository;

//     public HomeController(ProductService service , ProductRepository repository){
//         this.service=service;
//         this.repository=repository;
//     }
//     public ProductRepository getProductRepository() {
//         return repository;
//     }



//     public void setProductRepository(ProductRepository repository) {
//         this.repository = repository;
//     }




 

//   @ModelAttribute("Products")
//     public List <Product> populateProducts(){
//         return repository.findAll();
//     }


}