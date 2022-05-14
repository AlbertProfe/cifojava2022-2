package com.company.service;

import com.company.model.Order;
import com.company.repository.OrderRepository;

public class OrderService {

    public static void create (Order orderToCreate){

        OrderRepository.create(orderToCreate);
    }
}
