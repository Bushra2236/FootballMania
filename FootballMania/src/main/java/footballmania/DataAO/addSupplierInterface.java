package footballmania.DataAO;

import footballmania.Model.addSupplierModel;

public interface addSupplierInterface {
	void addSupplier(addSupplierModel supplier);
	String displaySupplier();
	addSupplierModel fetchSupplier(String id);
	void updateSupplier(addSupplierModel supplier);
	void deleteSupplier(String id);
	String generateSuppId();
}
