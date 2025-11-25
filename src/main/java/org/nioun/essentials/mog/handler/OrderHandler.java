package org.nioun.essentials.mog.handler;

import org.nioun.essentials.mog.model.Order;
import org.nioun.essentials.mog.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderHandler {

    private final OrderRepository commandRepo;

    public OrderHandler(OrderRepository commandRepo){
        this.commandRepo = commandRepo;
    }

    public Order saveCommand(Order Order){
        return  commandRepo.save(Order);
    }

}
