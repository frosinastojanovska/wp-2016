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
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Confirmation</title></head><body><h3>Confirmation</h3>");
        writer.println(String.format("<div>%s <br> Name: %s <br> Address: %s <br> Pizza size: %s <br></div>", userAgent, name, address, pizzaSize));
        writer.print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
