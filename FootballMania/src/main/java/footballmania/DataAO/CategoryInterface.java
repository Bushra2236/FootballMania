package footballmania.DataAO;

import footballmania.Model.CategoryModel;

public interface CategoryInterface {

	void addCat (CategoryModel category);
	String displayCat();
	CategoryModel fetchCat(String id);
	void updateCat(CategoryModel category);
	void deleteCat(String id);
	String generateCatId();
}
