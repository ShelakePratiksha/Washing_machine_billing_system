package pratu11;



import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 

@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve input values from the form
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();

        // Logging the inputs to check what the servlet receives
        System.out.println("Received Username: " + username);
        System.out.println("Received Password: " + password);

        // Correct username and password
        String correctUsername = "Ranii";
        String correctPassword = "12345";

        // Retrieve the quantities for shirts, pants, and t-shirts
        int shirtQty = Integer.parseInt(request.getParameter("shirt"));
        int pantQty = Integer.parseInt(request.getParameter("pant"));
        int tshirtQty = Integer.parseInt(request.getParameter("tshirt"));

        // Define the prices for each item
        int shirtPrice = 500;
        int pantPrice = 700;
        int tshirtPrice = 300;

        // Calculate total clothes and total price
        int totalClothes = shirtQty + pantQty + tshirtQty;
        int totalPrice = (shirtQty * shirtPrice) + (pantQty * pantPrice) + (tshirtQty * tshirtPrice);

        // Set response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Validate username and password
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            // Login successful, calculate and display the bill
            out.println("<html><body>");
            out.println("<center>");
            out.println("<h2><span style='color:red;font-size:50px;font-weight:bold'>!.....Washing Machine Bill.....!</span></h2>");
            out.println("<h3>Username: " + username + "</h3>");
            out.println("<h3>Total Clothes: " + totalClothes + "</h3>");
            out.println("<h3>Total Price: Rs" + totalPrice + "</h3>");
            out.println("<br><a href='Calculate.html'>Go Back</a>"); // A link to go back to the input form
            out.println("</center>");
            out.println("</body></html>");
        } else {
            // Login failed, show error message
            out.println("<html><body>");
            out.println("<center>");
            out.println("<h3 style='color:red'>Invalid Username or Password. Please try again.</h3>");
            out.println("<br><a href='Calculate.html'>Go Back</a>");
            out.println("</center>");
            out.println("</body></html>");
        }
    }
}

