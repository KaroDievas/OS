package main;

public class memory {

	private String userMemory[][];
	private String superVisorMemory[][];
	
	public void inicializeMemory() {
		this.userMemory = new String[1999][3];
		this.superVisorMemory = new String[999][3];
	}

	public String getUserMemory(int block, int word) {
		return userMemory[block][word];
	}

	public void setUserMemory(String[][] userMemory) {
		this.userMemory = userMemory;
	}

	public String getSuperVisorMemory(int block, int word) {
		return superVisorMemory[block][word];
	}

	public void setSuperVisorMemory(String[][] superVisorMemory) {
		this.superVisorMemory = superVisorMemory;
	}
	
}