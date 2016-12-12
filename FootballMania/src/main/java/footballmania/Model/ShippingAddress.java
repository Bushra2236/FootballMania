package footballmania.Model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class ShippingAddress implements Serializable {

	private static final long serialVersionUID = 1L;
	

	//private String shippingId;
	private String shippingAddress1;
	private String shippingAddress2;
	private String shippingCity;
	private String shippingState;
	private String shippingPincode;
	
	public ShippingAddress()
	{
		//super();
	}

	//public String getShippingId() {return shippingId;}

	//public void setShippingId(String shippingId) {this.shippingId = shippingId;}

	public String getShippingAddress1() {
		return shippingAddress1;
	}

	public void setShippingAddress1(String shippingAddress1) {
		this.shippingAddress1 = shippingAddress1;
	}

	public String getShippingAddress2() {
		return shippingAddress2;
	}

	public void setShippingAddress2(String shippingAddress2) {
		this.shippingAddress2 = shippingAddress2;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingPincode() {
		return shippingPincode;
	}

	public void setShippingPincode(String shippingPincode) {
		this.shippingPincode = shippingPincode;
	}
	
	
}
