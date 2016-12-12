package footballmania.Model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderDetails implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private String userId;
	@Id
	@GeneratedValue
	private String orderId;
	
	@Embedded
	private paymentMethod paymentMethod;
	@Embedded
	private BillingAddress billingAddress;
	@Embedded
	private ShippingAddress shippingAddress;
	private long totalAmount;
	private CartDetails cart;
	
	public OrderDetails() {
	//	super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public paymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(paymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public CartDetails getCart() {
		return cart;
	}

	public void setCart(CartDetails cart) {
		this.cart = cart;
	}
	
	
	
}
