package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Order;

/**
 * Created by Frosina on 21.11.2016.
 */
public interface IOrderService {

    public Order placeOrder(String pizzaType, String clientName, String address);

}
