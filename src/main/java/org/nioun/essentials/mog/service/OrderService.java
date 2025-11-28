package org.nioun.essentials.mog.service;

import java.util.List;
import java.util.Optional;

import org.nioun.essentials.mog.handler.InventoryHandler;
import org.nioun.essentials.mog.model.Order;
import org.nioun.essentials.mog.handler.InventoryHandler;
import org.nioun.essentials.mog.handler.OrderHandler;

public interface OrderService {

    

     List<Order> findAll();

     Order findById(int id);

     void delete(int id);

     void save(Order order);
     
     Order placeAOrder(Order order);
	

}
