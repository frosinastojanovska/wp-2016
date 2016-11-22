package mk.ukim.finki.wp.service.impl;

import java.util.ArrayList;
import java.util.List;
import mk.ukim.finki.wp.service.IPizzaService;
import org.springframework.stereotype.Service;

/**
 * Created by Frosina on 21.11.2016.
 */
@Service
public class PizzaService implements IPizzaService {

    public List<String> getPizzaTypes(){
        List<String> pizzaTypes = new ArrayList<String>();
        pizzaTypes.add("Small");
        pizzaTypes.add("Medium");
        pizzaTypes.add("Large");
        return pizzaTypes;
    }
}
