package org.nioun.essentials.mog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.nioun.essentials.mog.handler.InventoryHandler;
import org.nioun.essentials.mog.handler.OrderHandler;
import org.nioun.essentials.mog.model.Order;
import org.nioun.essentials.mog.model.Product;
import org.nioun.essentials.mog.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    OrderRepository orderRepository;
	 private final InventoryHandler inventoryHandler;
     private final OrderHandler orderHandler;

    
	public OrderServiceImpl( InventoryHandler inventoryHandler , OrderHandler orderHandler){
		this.inventoryHandler =  inventoryHandler;
		this.orderHandler = orderHandler;
	}

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }



    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
	
	//Get All Orders
	public List<Order> findAll(){
		return orderRepository.findAll();
	}	
	
	//Get Order By Id
	public Optional<Order> findById(int id) {
		return orderRepository.findById(id);
	}	
	
	//Delete Order
	public void delete(int id) {
		orderRepository.deleteById(id);
	}
	
	//Update Order
	public void save( Order Order) {
		orderRepository.save(Order);
	}

	public Order placeAOrder (Order order){

		// get product (Product) inventory
		Product product = inventoryHandler.getProduct(order.getIdProduct());

		// validate stock availability
		validateStock(order , product);

		// update total price in order(Order) entity
		order.setPrixTotal(order.getQuantite()*product.getPrix());

		// save order
		Order saveOrder = orderHandler.saveCommand(order);
		
		// update stock in inventory
		updateInventory(order,product);

		

		return saveOrder;
	}

	private void validateStock(Order order , Product product ){
		if (order.getQuantite() > product.getStocks()){
			throw new RuntimeException("Insufficient stock availability");
		}
	}

	private void updateInventory(Order order , Product product){
			int availableStock = product.getStocks() - order.getQuantite() ;
		product.setStocks(availableStock);
		inventoryHandler.updateProductDetails(product);
		}

}
