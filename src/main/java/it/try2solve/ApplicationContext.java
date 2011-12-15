package it.try2solve;

public class ApplicationContext {
	
	private static ApplicationContext instance = new ApplicationContext();
	
	private ApplicationContext() {
		
	}
	
	public static ApplicationContext getInstance() {
		return instance;
	}

	volatile boolean inMaintenance = false;
	
	public boolean isInMaintenance() {
		return inMaintenance;
	}
	
	public void setInMaintenance(boolean value) {
		inMaintenance = value;
	}
	
}
