package footballmania.DataAO;

import footballmania.Model.SupplierModel;

public interface SupplierInterface {
	void addSupplier(SupplierModel supplier);
	String displaySupplier();
	SupplierModel fetchSupplier(String id);
	void updateSupplier(SupplierModel supplier);
	void deleteSupplier(String id);
	String generateSuppId();
}
