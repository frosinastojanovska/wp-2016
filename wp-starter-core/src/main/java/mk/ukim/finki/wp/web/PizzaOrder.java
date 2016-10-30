package mk.ukim.finki.wp.web;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Frosina on 30.10.2016.
 */
@WebServlet(name = "PizzaOrder")
public class PizzaOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pizzaSize = request.getParameter("size");
        request.getSession().setAttribute("pizzaSize", pizzaSize);
        RequestDispatcher dispatcher = request.getRequestDispatcher("deliveryInfo.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
