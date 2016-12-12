package footballmania.Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private String cartId;
	private String userId;
	private String productName;
	private int quantity;
	private char status;
	private double price;
	@Transient
	private Date add_date;
	
	public CartDetails() {
		//super();
	}

	

	public String getCartId() {
		return cartId;
	}



	public void setCartId(String cartId) {
		this.cartId = cartId;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	

	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}
