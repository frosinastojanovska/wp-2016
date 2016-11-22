package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.impl.OrderService;
import mk.ukim.finki.wp.service.impl.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Frosina on 22.11.2016.
 */
@Controller
public class PizaOrderController {

    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        List<String> pizzaTypes = pizzaService.getPizzaTypes();
        return new ModelAndView("pizza_index", "pizzaTypes", pizzaTypes);
    }

    @RequestMapping(value = "/showClientInfo", method = RequestMethod.POST)
    public ModelAndView showClientInfo(@RequestParam String pizzaType, HttpSession session){
        session.setAttribute("pizzaType", pizzaType);
        return new ModelAndView("deliveryInfo");
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public  ModelAndView placeOrder(@RequestParam String clientName, @RequestParam String clientAddress, HttpSession session){
        String pizzaType = (String)session.getAttribute("pizzaType");
        Order order = orderService.placeOrder(pizzaType, clientName, clientAddress);
        return new ModelAndView("orderDetails", "order", order);
    }

}
