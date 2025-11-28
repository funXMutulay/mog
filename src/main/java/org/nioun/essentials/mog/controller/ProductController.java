package org.nioun.essentials.mog.controller;


import java.io.IOException;
import java.util.List;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import org.nioun.essentials.mog.model.Product;
import org.nioun.essentials.mog.model.Categorie;
import org.nioun.essentials.mog.repository.ProductRepository;
import org.nioun.essentials.mog.service.ProductService;
import org.nioun.essentials.mog.service.FileUploadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin(origins="https://zesty-reverence-production-f083.up.railway.app" , maxAge=3600)
 @Controller
//@RestController
@Tag(name = "Product", description = "Product management APIs")
public class ProductController {

    @Autowired
    public ProductService service;

    @Autowired
    public ProductRepository repository;

    public ProductController(ProductService service , ProductRepository repository){
        this.service=service;
        this.repository=repository;
    }


    
    @GetMapping(value="/")
    public  String welcome (Model model){
    
     model.addAttribute("products", service.findAll()); 
    return "index";
 }

  
    @GetMapping(value="/parfum")
    public  String getParfumProducts (Model model){
    //List<Product> productsParfum = repository.getByCategorie(Categorie.Parfum);
     List<Product> productsParfum = repository.findByCategorie("parfum");
     model.addAttribute("productsParfum", productsParfum); 
    return "parfum";
 }

    
    @GetMapping(value="/corps")
    public  String getCorpsProducts (Model model){
    List<Product> productsCorps = repository.findByCategorie("corps");
     model.addAttribute("productsCorps", productsCorps); 
    return "corps";
    }

    
    @GetMapping(value="/cheveux")
    public  String getCheveuxProducts (Model model){
    List<Product> productsCheveux = repository.findByCategorie("cheveux");
     model.addAttribute("productsCheveux", productsCheveux); 
    return "cheveux";
    }

    
    @GetMapping(value="/bebe")
    public  String getBebeProducts (Model model){
    List<Product> productsBebe = repository.findByCategorie("bebe");
     model.addAttribute("productsBebe", productsBebe); 
    return "bebe";
    }

     @GetMapping(value="/makeup")
    public  String getMakeupProducts (Model model){
    List<Product> productsMakeup = repository.findByCategorie("makeup");
     model.addAttribute("productsMakeup", productsMakeup); 
    return "makeup";
 }

  @GetMapping(value="/visage")
    public  String getVisageProducts (Model model){
    List<Product> productsVisage = repository.findByCategorie("visage");
     model.addAttribute("productsVisage", productsVisage); 
    return "visage";
 }

    @Operation(
      summary = "Retrieve all LOcations by name",
      description = "Get a Product object by specifying its id. The response is Product object with name.",
      tags = { "tutorials", "get" })
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value="/products")
    // The line `return "Products";` in the `addNewProduct` method of the `ProductController` class is
    // returning a String value "Products". In this context, it is likely used to specify the name of
    // the view template that should be rendered after the processing of adding a new Product is
    // completed.
    public String getAllProducts(Model model) {
        model.addAttribute("products", service.findAll());
        return "products";
    }

    @ModelAttribute("products")
    public List <Product> populateProducts(){
        return this.repository.findAll();
    }


     @ModelAttribute("productsVisage")
    public List <Product> populateProductsVisage(){
        return this.repository.findByCategorie("visage");
    }

     @ModelAttribute("productsParfum")
    public List <Product> populateProductsParfum(){
        return this.repository.findByCategorie("parfum");
    }

     @ModelAttribute("productsBebe")
    public List <Product> populateProductsBebe(){
        return this.repository.findByCategorie("bebe");
    }

     @ModelAttribute("productsCorps")
    public List <Product> populateProductsCorps(){
        return this.repository.findByCategorie("corps");
    }

     @ModelAttribute("productsCheveux")
    public List <Product> populateProductsCheveux(){
        return this.repository.findByCategorie("cheveux");
    }

     @ModelAttribute("productsMakeup")
    public List <Product> populateProductsMakeup(){
        return this.repository.findByCategorie("makeup");
    }






    //     @GetMapping(value="/Products")
//    String getProducts(Model model ){
    
//     model.addAttribute("Products", this.repository.findAll());
//     return "Products";
//    }

   //Add Product

   
	 //Add Product
	@PostMapping(value="/products/addNew")
	public String addNewProduct(@ModelAttribute ("product") Product product , 
                                      BindingResult bindingResult ,
                                      RedirectAttributes redirectAttributes,
                                      @RequestParam("file") MultipartFile file ,
                                      Model model ) throws IOException {

            if(!file.isEmpty()){
                         
                String  fileName = StringUtils.cleanPath(file.getOriginalFilename());
                product.setImage(fileName);
                Product savedProduct = service.saveProduct(product);

                //customer-photos/{customerId}/fileName
                String uploadDir1="product-photos/"+savedProduct.getId();
                FileUploadService.uploadFile(uploadDir1,fileName,file);
                         
            }               
            
                return  "products"  ;
	}	

    @PostMapping("/edit/{id}")
    public String editProduct(Product product, Model model, @PathVariable String id) {
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "products";
    }
    


   @ResponseBody
   @DeleteMapping(value="/products/{id}" )
   String delete(@PathVariable Integer id){

    System.out.println("Going to delete product #" + id);
    repository.deleteById(id);
    return "redirect:/ " ;
   }

   
   @PostMapping("/products/reset")
   HtmxResponse reset(Model model){
    
    model.addAttribute("products", this.repository.findAll());
    return new HtmxResponse()
               .addTemplate("products :: products-list ")
               .addTemplate("products :: products-form") ;
   }





}
