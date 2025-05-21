package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		RazorpayClient razorpay;
		
		PrintWriter out = resp.getWriter();

		try {
			 razorpay = new RazorpayClient("rzp_test_adf50thFy1ZNIR", "1uBejRA3KbiC2qaGYj1C2GXz");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount",amount*100);
			orderRequest.put("currency","INR");
			orderRequest.put("receipt", "receipt#1");
			JSONObject notes = new JSONObject();
			notes.put("notes_key_1","Tea, Earl Grey, Hot");
			orderRequest.put("notes",notes);

			
			Order order = razorpay.orders.create(orderRequest);
		
			out.append(order.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
