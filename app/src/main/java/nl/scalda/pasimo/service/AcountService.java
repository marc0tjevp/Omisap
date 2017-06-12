package nl.scalda.pasimo.service;

public class AcountService {
	
	private static AcountService instance = null;
	
	public static AcountService getInstance() {
		if (instance == null) {
			instance = new AcountService();
		}
		return instance;
	}
}
