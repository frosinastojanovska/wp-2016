package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.impl.OrderService;
import mk.ukim.finki.wp.service.impl.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.util.List;

/**
 * Created by Frosina on 22.11.2016.
 */
@Controller
@RequestMapping(value = "/")
public class PizaOrderController {

    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index(){
        List<String> pizzaTypes = pizzaService.getPizzaTypes();
        return new ModelAndView("pizza_index", "pizzaTypes", pizzaTypes);
    }

    @RequestMapping(value = "/showClientInfo", method = RequestMethod.POST)
    public ModelAndView showClientInfo(@RequestParam String pizzaType, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        session.setAttribute("pizzaType", pizzaType);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("clientInfo")) {
                    String value = cookie.getValue();
                    String[] parts = value.split(",");
                    String clientName = parts[0];
                    String clientAddress = parts[1];
                    try{
                        request.getRequestDispatcher(String.format("/placeOrder?clientName=%s&clientAddress=", clientName, clientAddress)).forward(request, response);
                    }
                    catch (Exception e){}

                }
            }
        }
        return new ModelAndView("deliveryInfo");
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public  ModelAndView placeOrder(@RequestParam String clientName, @RequestParam String clientAddress, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        String value = String.format("%s, %s", clientName, clientAddress);
        Cookie cookie = new Cookie("clientInfo", value);
        response.addCookie(cookie);
        String pizzaType = (String)session.getAttribute("pizzaType");
        Order order = orderService.placeOrder(pizzaType, clientName, clientAddress);
        return new ModelAndView("orderDetails", "order", order);
    }

}
