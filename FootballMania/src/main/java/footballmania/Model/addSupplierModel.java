package footballmania.Model;

import javax.persistence.*;

@Entity
@Table (name="Supplier")
public class addSupplierModel {

	@Id
	private String supplierId;
	private String supplierName;
	private String supplierAdd1;
	private String supplierAdd2;
	private String supplierCity;
	private String supplierState;
	private String supplierPin;
	private String supplierNumber;

	
	
	public addSupplierModel() {
		//super();
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAdd1() {
		return supplierAdd1;
	}
	public void setSupplierAdd1(String supplierAdd1) {
		this.supplierAdd1 = supplierAdd1;
	}
	public String getSupplierAdd2() {
		return supplierAdd2;
	}
	public void setSupplierAdd2(String supplierAdd2) {
		this.supplierAdd2 = supplierAdd2;
	}
	public String getSupplierCity() {
		return supplierCity;
	}
	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}
	public String getSupplierState() {
		return supplierState;
	}
	public void setSupplierState(String supplierState) {
		this.supplierState = supplierState;
	}
	public String getSupplierPin() {
		return supplierPin;
	}
	public void setSupplierPin(String supplierPin) {
		this.supplierPin = supplierPin;
	}
	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	
	
}
