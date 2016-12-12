package footballmania.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class BillingAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	
	//private String billingId;
	private String billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private String billingState;
	private String billingPincode;
	
	public BillingAddress() {
		//super();
	}

	//public String getBillingId() {return billingId;}

	//public void setBillingId(String billingId) {this.billingId = billingId;}

	public String getBillingAddress1() {
		return billingAddress1;
	}

	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}

	public String getBillingAddress2() {
		return billingAddress2;
	}

	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingPincode() {
		return billingPincode;
	}

	public void setBillingPincode(String billingPincode) {
		this.billingPincode = billingPincode;
	}
	
	
	
}
