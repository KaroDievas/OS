package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class procesor {
	/**
	 * Procesor registers
	 */
	private int ptr;
	private String mr;
	private int ip;
	private int cs;
	private int ds;
	private int sp;
	/*
	 * interrupts
	 */
	private int si;
	private int ti;
	private int ioi;
	private int pi;
	/*
	 * procesor mode
	 * mode = 1 processor running in supervisor mode
	 * mode = 0 processor running in user mode
	 */
	private int mode;
	
	private memory RAM = null;
	private channelMechanism channel = null;
	private pagination paginationMechanism = null;
	/**
	 * @param args
	 */
	
	public void inicialize() {
		this.setCs(0000);
		this.setDs(0000);
		this.setIoi(0000);
		this.setIp(0000);
		this.setMode(1);
		this.setMr("0");
		this.setPi(0000);
		this.setPtr(0000);
		this.setSi(0000);
		this.setSp(0000);
		this.setTi(0000);
		this.createMemory();
		channel = new channelMechanism();
		paginationMechanism = new pagination(this.getRAM());
	}
	
	public void createMemory() {
		this.RAM = new memory();
		this.RAM.inicializeMemory();
	}
	
	public void freeMemory(int memoryType, int block, int word) {
		if (memoryType == 1){
			this.RAM.setSuperVisorMemory(block, word, "0");
		}
		if (memoryType == 2) {
			this.RAM.setUserMemory(block, word, "0");
		}
	}
	
	public int isCommand(String word) {
		
		int commandType = 0;
		switch (word) {
				/*
				 * 
				 */
	        case "ADDS":  commandType = 1;
                break;
	        case "SUBS":  commandType = 2;
            	break;
	        case "MULS":  commandType = 3;
            	break;
	        case "DIVS":  commandType = 4;
	        	break;
	        case "ADDR":  commandType = 5;
            	break;
	        case "SUBR":  commandType = 6;
        		break;
	        case "MULR":  commandType = 7;
            	break;
	        case "DIVR":  commandType = 8;
            	break;
		        /*
		         * 
		         */
	        case "PUSH":  commandType = 9;
            	break;
	        case "POP":  commandType = 10;
	        	break;
	        	/**
	        	 * 
	        	 */
	        case "CMPS":  commandType = 11;
            	break;
	        case "CMPR":  commandType = 12;
            	break;
            	/**
            	 * 
            	 */
	        case "JMP":  commandType = 13;
            	break;
            	/**
            	 * 
            	 */
	        case "READ":  commandType = 14;
            	break;
	        case "PRINT":  commandType = 15;
            	break;
	        case "LOAD":  commandType = 16;
	        	break;
	        case "WRITE":  commandType = 17;
            	break;
            	/**
            	 * 
            	 */
	        case "HALT":  commandType = 18;
        		break;
	        case "MOV":  commandType = 19;
        		break;
	        default: this.setPi(2);
                break;
	    }
		return commandType;
	}
	
	
	public int interrupting() {
		if (this.getIoi() == 0) {
			return 1;
		}
		else if (this.getSi() == 0) {
			return 2;
		}
		else if (this.getPi() == 0) {
			return 3;	
		}
		else if (this.getTi() != 0) {
			return 4;
		}
		else {
			return 0;
		}
		
	}
	
	public void READ() {
		String line = null;
		
	}
	
	public void PRINT(String value) {
		this.channel.base(2, value);
	}
	
	public void JMP(int poslinkis) {
		this.setIp(this.getIp() + poslinkis);
	}
	
	public int CMPR(int value1, int value2) {
		if (value1 > value2) {
			return 1;
		}
		else if(value1 < value2) {
			return 2;
		}
		else {
			return 0;
		}
	}
	
	public void MOV(String reg1, String reg2) {
		if (reg1 == "MR" && reg2 == "DS") {
			this.setMr(Integer.toString(this.getDs()));
		}
		else if (reg1 == "MR" && reg2 == "CS") {
			this.setMr(Integer.toString(this.getCs()));
		}
		else if (reg1 == "MR" && reg2 == "IP") {
			this.setMr(Integer.toString(this.getIp()));
		}
		else if (reg1 == "MR" && reg2 == "SP") {
			this.setMr(Integer.toString(this.getSp()));
		}
		else if (reg1 == "DS" && reg2 == "MR") {
			this.setDs(Integer.parseInt(this.getMr()));
		}
		else if (reg1 == "DS" && reg2 == "CS") {
			this.setDs(this.getCs());
		}
		else if (reg1 == "DS" && reg2 == "IP") {
			this.setDs(this.getIp());
		}
		else if (reg1 == "DS" && reg2 == "SP") {
			this.setDs(this.getSp());
		}
		else if (reg1 == "CS" && reg2 == "MR") {
			this.setCs(Integer.parseInt(this.getMr()));
		}
		else if (reg1 == "CS" && reg2 == "DS") {
			this.setCs(this.getDs());
		}
		else if (reg1 == "CS" && reg2 == "IP") {
			this.setCs(this.getIp());
		}
		else if (reg1 == "CS" && reg2 == "SP") {
			this.setCs(this.getSp());
		}
		else if (reg1 == "IP" && reg2 == "MR") {
			this.setIp(Integer.parseInt(this.getMr()));
		}
		else if (reg1 == "IP" && reg2 == "DS") {
			this.setIp(this.getDs());
		}
		else if (reg1 == "IP" && reg2 == "SP") {
			this.setIp(this.getSp());
		}
		else if (reg1 == "IP" && reg2 == "CS") {
			this.setIp(this.getCs());
		}
		else if (reg1 == "SP" && reg2 == "MR") {
			this.setSp(Integer.parseInt(this.getMr()));
		}
		else if (reg1 == "SP" && reg2 == "DS") {
			this.setSp(this.getDs());
		}
		else if (reg1 == "SP" && reg2 == "CS") {
			this.setSp(this.getCs());
		}
		else if (reg1 == "SP" && reg2 == "IP") {
			this.setSp(this.getIp());
		}
		else if (reg1 == reg2) {
			
		}
		else {
			this.setPi(3);
		}
	}
	public void loadFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\KD\\Desktop\\2013-02-17\\2013-02-17_13-50-37.txt")))
		{
			String sCurrentLine;
			
			while ((sCurrentLine = br.readLine()) != null) {
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public memory getRAM() {
		return RAM;
	}
	
	public int getPtr() {
		return ptr;
	}

	public void setPtr(int ptr) {
		this.ptr = ptr;
	}

	public String getMr() {
		return mr;
	}

	public void setMr(String mr) {
		this.mr = mr;
	}

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	public int getDs() {
		return ds;
	}

	public void setDs(int ds) {
		this.ds = ds;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getSi() {
		return si;
	}

	public void setSi(int si) {
		this.si = si;
	}

	public int getTi() {
		return ti;
	}

	public void setTi(int ti) {
		this.ti = ti;
	}

	public int getIoi() {
		return ioi;
	}

	public void setIoi(int ioi) {
		this.ioi = ioi;
	}

	public int getPi() {
		return pi;
	}

	public void setPi(int pi) {
		this.pi = pi;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

}
