package footballmania.DataAO;

import java.util.List;

import footballmania.Model.CartDetails;

public interface cartInterface {

	public List<CartDetails> list (String id);
	
	public void save(CartDetails cartDetails);
	public void update(String id, int quant);
	public String delete (String id);
	public String displayCart();
	public long TotalAmount(String id);

	CartDetails fetchcart(String id);
}
