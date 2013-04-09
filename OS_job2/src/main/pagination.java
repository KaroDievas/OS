package main;

public class pagination {

	private memory RAM = null;
	private int PTR = 0;
	/*
	 * ramMode = 0, user memory
	 * ramMode = 1, super memory
	 */
	private int ramMode = 0;
	
	
	public pagination(memory rAM) {
		this.RAM = rAM;
	}
	
	public void setData(int PRT, int ramMode) {
		this.PTR = PRT;
		this.ramMode = ramMode;
	}
	
	public int getBlockNumber() {
		int blockNumber = -1;
		if (this.ramMode == 0) {
			
		}
		if (this.ramMode == 1) {
			
		}	
		return blockNumber;
	}
	
	public int getWordNumber() {
		int WordNumber = -1;
		if (this.ramMode == 0) {
			
		}
		if (this.ramMode == 1) {
			
		}
		return WordNumber;
	}
	
	public int getbyteNumber() {
		int byteNumber = -1;
		if (this.ramMode == 0) {
			
		}
		if (this.ramMode == 1) {
			
		}
		return byteNumber;
	}
}
