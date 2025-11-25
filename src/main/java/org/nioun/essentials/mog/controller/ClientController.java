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


import org.nioun.essentials.mog.model.Client;
import org.nioun.essentials.mog.service.ClientService;
import org.nioun.essentials.mog.service.FileUploadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Controller
@CrossOrigin(origins="*", maxAge=3600 )
@Tag(name = "Client", description = "Client management APIs")
public class ClientController {

    @Autowired
    public ClientService service;

    public ClientController(ClientService sercice){
        this.service = service;
    }


     @ModelAttribute("clients")
    public List <Client> populateClients(){
        return this.service.findAll();
    }

    @Operation(
      summary = "Retrieve all LOcations by name",
      description = "Get a Client object by specifying its id. The response is Client object with name.",
      tags = { "tutorials", "get" }
      )

      @ApiResponses({
      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Client.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value="/clients")
    public String getAllClients(Model model) {
        model.addAttribute("clients", service.findAll());
        return "clients";
    }

    //Add Client
	@PostMapping(value="/clients/addNew")
	public String addNewClient(@ModelAttribute ("client") Client client , 
                                      BindingResult bindingResult ,
                                      RedirectAttributes redirectAttributes,
                                      @RequestParam("file") MultipartFile file ,
                                      Model model ) throws IOException {

            if(!file.isEmpty()){
                         
                String  fileName = StringUtils.cleanPath(file.getOriginalFilename());
                client.setPhoto(fileName);
                Client savedClient = service.saveClient(client);

                //customer-photos/{customerId}/fileName
                String uploadDir="customer-photos/"+savedClient.getId();
                FileUploadService.uploadFile(uploadDir,fileName,file);
                         
            }               
            
                return  "clients"  ;
	}	

   
    @PostMapping("/edit-client/{id}")
    public String editClient(@ModelAttribute ("new-client")Client client, Model model, @PathVariable String id) {
       
        model.addAttribute("client", client);
        model.addAttribute("id", id);
        return "clients";
    }
    

   

   @ResponseBody
   @DeleteMapping(value="/clients/{id}" )
   String delete(@PathVariable Integer id){

    System.out.println("Going to delete Client #" + id);
    service.deleteClient(id);
    return "redirect:/ " ;
   }
   
   
}
