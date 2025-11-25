package org.nioun.essentials.mog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.nioun.essentials.mog.model.Facture;
import org.nioun.essentials.mog.repository.FactureRepository;
import org.nioun.essentials.mog.service.FactureService;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;


@CrossOrigin(origins="*" , maxAge=3600)
@Controller
public class FactureController {

    @Autowired
private final FactureRepository repository;

@Autowired
private FactureService service;
@Autowired
private final ApplicationEventPublisher publisher;

    public FactureController(FactureRepository repository ,
                            ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @ModelAttribute("factures")
    public List <Facture> populateFactures(){
        return this.repository.findAll();
    }

    @GetMapping(value="/factures")
   String getFactures(Model model ){
    
    model.addAttribute("factures", this.repository.findAll());
    return "factures";
   }

   //Add Client
	@PostMapping(value="/factures/addNew")
	public HtmxResponse addNewFacture(@ModelAttribute ("new-facture") Facture facture) {
		service.save(facture);
		return  new HtmxResponse()
                    .addTemplate("factures :: factures-list")
                    .addTemplate("factures :: factures-form") ;
	}	
    

    @PostMapping("/edit-facture/{id}")
    public String editFacture(Facture facture, Model model, @PathVariable String id) {
        model.addAttribute("facture", facture);
        model.addAttribute("id", id);
        return "factures";
    }
   @PostMapping("/factures/reset")
   HtmxResponse reset(Model model){
    
    model.addAttribute("factures", this.repository.findAll());
    return new HtmxResponse()
               .addTemplate("factures :: factures-list ")
               .addTemplate("factures :: factures-form") ;
   }

   @ResponseBody
   @DeleteMapping(value="/factures/{id}" , produces = MediaType.TEXT_HTML_VALUE)
   String delete(@PathVariable Integer id){

    System.out.println("Going to delete Facture #" + id);
    repository.deleteById(id);
    return "redirect:/ " ;
   }
}