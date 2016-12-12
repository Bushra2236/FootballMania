package footballmania.DataAO;


import footballmania.Model.registerModel;

public interface registerInterface {

	void registerUser(registerModel reg);
	String fetchProducts(String id);
	String fetchTeams();
}
