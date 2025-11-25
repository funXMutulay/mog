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

import org.nioun.essentials.mog.model.Employer;
import org.nioun.essentials.mog.repository.EmployerRepository;
import org.nioun.essentials.mog.service.EmployerService;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;


@CrossOrigin(origins="*" , maxAge=3600)
@Controller
public class EmployerController {

    @Autowired
private final EmployerRepository repository;

@Autowired
private EmployerService service;
@Autowired
private final ApplicationEventPublisher publisher;

    public EmployerController(EmployerRepository repository ,
                            ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @ModelAttribute("employers")
    public List <Employer> populateEmployers(){
        return this.repository.findAll();
    }

    @GetMapping(value="/employers")
   String getEmployers(Model model ){
    
    model.addAttribute("employers", this.repository.findAll());
    return "employers";
   }

   //Add Client
	@PostMapping(value="/employers/addNew")
	public HtmxResponse addNewEmployer(@ModelAttribute ("new-employer") Employer employer) {
		service.save(employer);
		return  new HtmxResponse()
                    .addTemplate("employers :: employers-list")
                    .addTemplate("employers :: employers-form") ;
	}	
    

   @PostMapping("/employers/reset")
   HtmxResponse reset(Model model){
    
    model.addAttribute("employers", this.repository.findAll());
    return new HtmxResponse()
               .addTemplate("employers :: employers-list ")
               .addTemplate("employers :: employers-form") ;
   }

   @ResponseBody
   @DeleteMapping(value="/employers/{id}" , produces = MediaType.TEXT_HTML_VALUE)
   String delete(@PathVariable Integer id){

    System.out.println("Going to delete Employer #" + id);
    repository.deleteById(id);
    return "redirect:/ " ;
   }
}