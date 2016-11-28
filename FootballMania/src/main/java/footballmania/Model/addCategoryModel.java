package footballmania.Model;

import javax.persistence.*;

@Entity
@Table(name="Category")
public class addCategoryModel {

	@Id
	@Column(name="Category_Id")
	private String catId;
	@Column(name="Category_Name")
	private String catName;
	
	
	public addCategoryModel() {
		//super();
	}


	public String getCatId() {
		return catId;
	}


	public void setCatId(String catId) {
		this.catId = catId;
	}


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
}
