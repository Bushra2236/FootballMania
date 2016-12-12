package footballmania.Webflow;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import footballmania.Model.OrderDetails;
import footballmania.Model.ProductModel;
import footballmania.Model.ShippingAddress;
import footballmania.DataAO.orderDetailsInterface;
import footballmania.Model.BillingAddress;
import footballmania.Model.paymentMethod;

@Component
public class OrderWebFlow {

@Autowired
ShippingAddress shipping;

@Autowired
BillingAddress billing;

@Autowired
paymentMethod payment;

@Autowired
OrderDetails order;

@Autowired
HttpSession httpSession;

@Autowired
orderDetailsInterface addOrder;

public OrderDetails initFlow(){
	System.out.println("init starts");
	order = new OrderDetails();
	System.out.println("init ends");
	
	return order;
}

public String addShippingDetails (OrderDetails order, ShippingAddress shipping){

	System.out.println("addShipping Starts");
	order.setShippingAddress(shipping);
	System.out.println("addShipping Ends");
	System.out.println(order.getShippingAddress());
return "success";
}

public String addBillingDetails (OrderDetails order, BillingAddress billing){
	
	System.out.println("addBilling Starts");
	order.setBillingAddress(billing);
	System.out.println("addBilling Ends");
	System.out.println(order.getBillingAddress());
	return "success";
}

public String addPaymentDetails (OrderDetails order, paymentMethod payment){

	System.out.println("addPayment Starts");
	order.setPaymentMethod(payment);
	System.out.println("addPayment Ends");
	System.out.println(order.getPaymentMethod());
	this.orderConfirm(order);
	return "success";
}

public String orderConfirm (OrderDetails order){
	
	System.out.println("order confirm starts");
	addOrder.addOrder(order);
	System.out.println("order confirm ends");
	return "success";
}
}
