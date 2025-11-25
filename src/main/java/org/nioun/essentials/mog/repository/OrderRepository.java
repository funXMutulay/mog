package org.nioun.essentials.mog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.nioun.essentials.mog.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

}
