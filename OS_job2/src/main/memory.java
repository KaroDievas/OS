package main;

public class memory {

	private String userMemory[][][];
	private String superVisorMemory[][][];
	
	public void inicializeMemory() {
		this.userMemory = new String[200][10][4];
		this.superVisorMemory = new String[100][10][4];
	}

	public String getUserMemory(int block, int word, int bytee) {
		return userMemory[block][word][bytee];
	}

	public void setUserMemory(int block, int word, int bytee,  String value) {
		this.userMemory[block][word][bytee] = value;
	}

	public String getSuperVisorMemory(int block, int word, int bytee) {
		return superVisorMemory[block][word][bytee];
	}

	public void setSuperVisorMemory(int block, int word, int bytee, String value) {
		this.superVisorMemory[block][word][bytee] = value;
	}
	
}
