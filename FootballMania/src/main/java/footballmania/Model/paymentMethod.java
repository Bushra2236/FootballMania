package footballmania.Model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class paymentMethod implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String paymentMethod;
	
	
	public paymentMethod() {
	//	super();
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}
