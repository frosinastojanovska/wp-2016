package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Frosina on 22.11.2016.
 */
@Service
public class OrderService implements IOrderService {

    public Order placeOrder(String pizzaType, String clientName, String address){
        Random random = new Random();
        Long orderId = random.nextLong();
        Order order = new Order(pizzaType, clientName, address, orderId);
        return order;
    }
}
