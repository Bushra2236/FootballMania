package footballmania.Model;

import javax.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
public class addProductModel {
	
	@Id
	@Column(name="Prod_ID")
	private String prodId;
	@Column(name="Product_Name")
	private String prodName;
	@Column(name="Category_Id")
	private String prodCat;
	@Column(name="Product_Quantity")
	private int prodQuant;
	@Column(name="Supplier_Id")
	private String prodSupp;
	@Transient
	private MultipartFile prodImage;
	@Column(name="Product_Color")
	private String prodColor;
	@Column(name="Product_Size")
	private String prodSize;
	@Column(name="Product_Price")
	private int prodPrice;
	
	public addProductModel() {
		//super();
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdCat() {
		return prodCat;
	}
	public void setProdCat(String prodCat) {
		this.prodCat = prodCat;
	}
	public int getProdQuant() {
		return prodQuant;
	}
	public void setProdQuant(int prodQuant) {
		this.prodQuant = prodQuant;
	}
	public MultipartFile getProdImage() {
		return prodImage;
	}
	public void setProdImage(MultipartFile prodImage) {
		this.prodImage = prodImage;
	}
	public String getProdSupp() {
		return prodSupp;
	}
	public void setProdSupp(String prodSupp) {
		this.prodSupp = prodSupp;
	}
	public String getProdColor() {
		return prodColor;
	}
	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}
	public String getProdSize() {
		return prodSize;
	}
	public void setProdSize(String prodSize) {
		this.prodSize = prodSize;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

}
