package mk.ukim.finki.wp.web;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddressInfo")
public class AddressInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAgent = request.getHeader("user-agent");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String pizzaSize = request.getSession().getAttribute("pizzaSize").toString();
        PrintWriter writer = response.getWriter();
        writer.println(String.format("%s \n Name: %s \n Address: %s \n Pizza size: %s \n", userAgent, name, address, pizzaSize));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
