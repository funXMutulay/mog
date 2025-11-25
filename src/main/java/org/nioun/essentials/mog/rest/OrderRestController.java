package org.nioun.essentials.mog.rest;

import  org.nioun.essentials.mog.repository.ClientRepository;
import  org.nioun.essentials.mog.repository.ProductRepository;
import org.nioun.essentials.mog.service.OrderService;
import org.nioun.essentials.mog.dto.OrderRequest;
import org.nioun.essentials.mog.dto.OrderResponse;
import org.nioun.essentials.mog.model.Client;
import org.nioun.essentials.mog.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;



@RestController
public class OrderRestController {

    @Autowired
     OrderService service;


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public OrderRestController(ClientRepository clientRepository ,
                                 ProductRepository productRepository ,
                                 OrderService service){
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.service = service;
    }

    @PostMapping("/placeOrder")
    public Client placeOrder(@RequestBody OrderRequest request){
        return clientRepository.save(request.getClient());
    }

     @PostMapping("/placeAOrder")
    public ResponseEntity<?> placAeOrder(@RequestBody Order item){
        return ResponseEntity.ok(service.placeAOrder(item));
    }

    @GetMapping("/findAllOrders")
    public List<Client> findAllOrders(){
        return clientRepository.findAll();
    }

     @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInfos(){
        return clientRepository.getJointInformation() ;
    }

}
