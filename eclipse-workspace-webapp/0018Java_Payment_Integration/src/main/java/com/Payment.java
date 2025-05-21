package com;

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
public class Payment extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		double amt = Double.parseDouble(req.getParameter("amt"));

		PrintWriter out = resp.getWriter();
		
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", amt*100); // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
		orderRequest.put("currency","INR");
		orderRequest.put("receipt", "receipt#1");
		JSONObject notes = new JSONObject();
		notes.put("notes_key_1","Tea, Earl Grey, Hot");
		orderRequest.put("notes",notes);

		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_0EEuPSaIkgppcd", "lzrKE7PTTCO11b9PAEGb5EMs");
			
			Order order = razorpay.orders.create(orderRequest);
			
			out.append(order.toString());
			
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
