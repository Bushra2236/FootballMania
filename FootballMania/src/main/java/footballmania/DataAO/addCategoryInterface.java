package footballmania.DataAO;

import footballmania.Model.addCategoryModel;

public interface addCategoryInterface {

	void addCat (addCategoryModel category);
	String displayCat();
	addCategoryModel fetchCat(String id);
	void updateCat(addCategoryModel category);
	void deleteCat(String id);
	String generateCatId();
}
