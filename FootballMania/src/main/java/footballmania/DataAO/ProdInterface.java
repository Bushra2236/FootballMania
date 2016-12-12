package footballmania.DataAO;

import footballmania.Model.ProductModel;

public interface ProdInterface {

	void addProd(ProductModel product);
	String displayProduct();
	ProductModel fetchProduct(String id);
	void updateProduct(ProductModel product);
	void deleteProduct(String id);
	String displayCategory();
	String displaySupplier();
	String generateProdId();
}
