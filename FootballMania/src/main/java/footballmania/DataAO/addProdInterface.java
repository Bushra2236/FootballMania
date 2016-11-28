package footballmania.DataAO;

import footballmania.Model.addProductModel;

public interface addProdInterface {

	void addProd(addProductModel product);
	String displayProduct();
	addProductModel fetchProduct(String id);
	void updateProduct(addProductModel product);
	void deleteProduct(String id);
	String displayCategory();
	String displaySupplier();
	String generateProdId();
}
