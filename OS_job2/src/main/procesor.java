package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Vector;

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
	private BufferedReader br;
	private BufferedReader br2;
	private boolean isFirstWord = true;
	private boolean isStart = false;
	private boolean isEnd = false;
	private int maxIP = 0;
	private String fileName = "C:\\Users\\KD\\Desktop\\failas.txt";
	private String printRegisterName = "";
	
	
	public procesor() {
		this.inicialize();
		try {
			
			br = new BufferedReader(new FileReader(fileName));
			LineNumberReader  lnr = new LineNumberReader(br);
			try {
				lnr.skip(Long.MAX_VALUE);
				this.maxIP = lnr.getLineNumber();
				this.br = new BufferedReader(new FileReader(fileName));
			} catch (IOException e) {
				System.out.println("Klaida gaunant max failo eiluciu skaiciu");
			}
		} catch (IOException e) {
			System.out.println("Failas nerastas");
		}
		this.setMode(0);
	}
	/**
	 * Inicializuojame visas pradiniu kintamuju reiksmes
	 */
	public void inicialize() {
		this.setCs(0000);
		this.setDs(0000);
		this.setIoi(0000);
		this.setIp(0000);
		this.setMode(0);
		this.setMr("0");
		this.setPi(0000);
		this.setPtr(0000);
		this.setSi(0000);
		this.setSp(0000);
		this.setTi(255);
		this.createMemory();
		channel = new channelMechanism();
		paginationMechanism = new pagination(this.getRAM());
	}
	
	public void createMemory() {
		this.RAM = new memory();
		this.RAM.inicializeMemory();
	}
	
	public void freeMemory(int memoryType, int block, int word, int bytee) {
		if (memoryType == 1){
			this.RAM.setSuperVisorMemory(block, word, bytee, null);
		}
		if (memoryType == 2) {
			this.RAM.setUserMemory(block, word, bytee, null);
		}
	}
	
	public int isCommand(String word) {
		
		int commandType = 0;
		switch (word) {
				/*
				 * 
				 */
	        case "ADDR":  commandType = 1;
            	break;
	        case "SUBR":  commandType = 2;
        		break;
	        case "MULR":  commandType = 3;
            	break;
	        case "DIVR":  commandType = 4;
            	break;
		        /*
		         * 
		         */
	        case "PUSH":  commandType = 5;
            	break;
	        case "POP":  commandType = 6;
	        	break;
	        	/**
	        	 * 
	        	 */
	        
	        case "CMPR":  commandType = 7;
            	break;
            	/**
            	 * 
            	 */
	        case "JMP":  commandType = 8;
            	break;
            	/**
            	 * 
            	 */
	        case "HALT":  commandType = 9;
        		break;
	        case "MOV":  commandType = 10;
        		break;
	        default: this.setPi(2);
                break;
            	/**
            	 * 
            	 */
	        case "READ":  commandType = 11;
	        			this.setIoi(4);
            	break;
	        case "PRINT":  commandType = 12;
	        			this.setIoi(3);
            	break; 	
	    }
		return commandType;
	}
	
	
	public int interrupting() {
		if (this.getTi() == 0) {
			return 4;
		}
		else if (this.getIoi() > 0) {
			return 1;
		}
		else if (this.getSi() > 0) {
			return 2;
		}
		else if (this.getPi() > 0) {
			return 3;	
		}
		else {
			return 0;
		}
		
	}
	/*
	 * Programa halt viska nunulina isveda i ekrana, jog programa baigta
	 */
	public void HALT() {
		this.br = null;
		this.isEnd = false;
		this.isFirstWord = true;
		this.isStart = false;
		this.channel.base(2, "Programa baigia darba");
	}
	/**
	 * Programa nuskaito is klavieturos vedama teksta ir priskiria registrui
	 */
	public void READ() {
		String line = null;
		line = this.channel.base(1, "");
		this.mr = line;
		this.setIoi(0);
	}
	
	/*
	 * funkcija kreipiasi i kanalu mechanizma ir isspauzdina nurodyta teksta
	 */
	public void PRINT(String value) {
		if (this.printRegisterName.equalsIgnoreCase("")) {
			this.channel.base(2, value);
		}
		else {
			String printas = null;
			if (this.printRegisterName.equalsIgnoreCase("MR")) {
				printas = this.getMr();
			}
			else if (this.printRegisterName.equalsIgnoreCase("IP")) {
				printas = Integer.toString(this.getIp());
			}
			else if (this.printRegisterName.equalsIgnoreCase("CS")) {
				printas = Integer.toString(this.getCs());
			}
			else if (this.printRegisterName.equalsIgnoreCase("DS")) {
				printas = Integer.toString(this.getDs());
			}
			else if (this.printRegisterName.equalsIgnoreCase("SP")) {
				printas = Integer.toString(this.getSp());
			}
			else {
				printas = "0";
			}
			this.channel.base(2, printas);
		}
		this.setIoi(0);
	}
	
	
	public void JMP(int poslinkis) {
		int newIP = this.getIp() + poslinkis;
		if (newIP > this.maxIP) { //PI 1
			this.HALT();
			this.channel.base(2, "Pezengtas IP rezis");
		}
		else {
			int i = this.getIp();
			while(i < newIP) {
				i++;
			}
			this.setIp(newIP);
		}
	}
	
	public void CMPCheck(String value1, String value2) {
		int reiksme1 = 0;
		int reiksme2 = 0;
		if (value1.equalsIgnoreCase("MR")) {
			if (value1.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {  
	            //this.CMPR(Integer.parseInt(value1), Integer.parseInt(value2));
	        } else {  
	        	reiksme1 = -1;  
	        }   
		}
		else {
			reiksme1 = this.getRegisterValue(value1);
		}
		if (value2.equalsIgnoreCase("MR")) {
			if (value2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {  
	            //this.CMPR(Integer.parseInt(value1), Integer.parseInt(value2));
	        } else {  
	        	reiksme2 = -1;  
	        }   
		}
		else {
			reiksme2 = this.getRegisterValue(value2);
		}
		
		if (reiksme1 == -1 || reiksme2 == -1) {
			this.setMr("-1");
		}
		else {
			this.CMPR(reiksme1, reiksme2);
		}
	}
	
	public void CMPR(int value1, int value2) {
		if (value1 > value2) {
			this.setMr(Integer.toString(1));
		}
		else if(value1 < value2) {
			this.setMr(Integer.toString(2));
		}
		else {
			this.setMr(Integer.toString(0));
		}
	}
	
	public int getRegisterValue(String register) {
		if (register.equalsIgnoreCase("MR")) {
			return Integer.parseInt(this.getMr());
		}
		else if (register.equalsIgnoreCase("IP")) {
			return this.getIp();
		}
		else if (register.equalsIgnoreCase("CS")) {
			return this.getCs();
		}
		else if (register.equalsIgnoreCase("DS")) {
			return this.getDs();
		}
		else if (register.equalsIgnoreCase("SP")) {
			return this.getSp();
		}
		else {
			return 0;
		}
	}
	
	public void MOV(String reg1, String reg2) {
		if (reg1.equalsIgnoreCase("MR") && reg2.equalsIgnoreCase("DS")) {
			this.setMr(Integer.toString(this.getDs()));
		}
		else if (reg1.equalsIgnoreCase("MR") && reg2.equalsIgnoreCase("CS")) {
			this.setMr(Integer.toString(this.getCs()));
		}
		else if (reg1.equalsIgnoreCase("MR") && reg2.equalsIgnoreCase("IP")) {
			this.setMr(Integer.toString(this.getIp()));
		}
		else if (reg1.equalsIgnoreCase("MR") && reg2.equalsIgnoreCase("SP")) {
			this.setMr(Integer.toString(this.getSp()));
		}
		else if (reg1.equalsIgnoreCase("DS") && reg2.equalsIgnoreCase("MR")) {
			this.setDs(Integer.parseInt(this.getMr()));
		}
		else if (reg1.equalsIgnoreCase("DS") && reg2.equalsIgnoreCase("CS")) {
			this.setDs(this.getCs());
		}
		else if (reg1.equalsIgnoreCase("DS") && reg2.equalsIgnoreCase("IP")) {
			this.setDs(this.getIp());
		}
		else if (reg1.equalsIgnoreCase("DS") && reg2.equalsIgnoreCase("SP")) {
			this.setDs(this.getSp());
		}
		else if (reg1.equalsIgnoreCase("CS") && reg2.equalsIgnoreCase("MR")) {
			this.setCs(Integer.parseInt(this.getMr()));
		}
		else if (reg1.equalsIgnoreCase("CS") && reg2.equalsIgnoreCase("DS")) {
			this.setCs(this.getDs());
		}
		else if (reg1.equalsIgnoreCase("CS") && reg2.equalsIgnoreCase("IP")) {
			this.setCs(this.getIp());
		}
		else if (reg1.equalsIgnoreCase("CS") && reg2.equalsIgnoreCase("SP")) {
			this.setCs(this.getSp());
		}
		else if (reg1.equalsIgnoreCase("IP") && reg2.equalsIgnoreCase("MR")) {
			this.setIp(Integer.parseInt(this.getMr()));
		}
		else if (reg1.equalsIgnoreCase("IP") && reg2.equalsIgnoreCase("DS")) {
			this.setIp(this.getDs());
		}
		else if (reg1.equalsIgnoreCase("IP") && reg2.equalsIgnoreCase("SP")) {
			this.setIp(this.getSp());
		}
		else if (reg1.equalsIgnoreCase("IP") && reg2.equalsIgnoreCase("CS")) {
			this.setIp(this.getCs());
		}
		else if (reg1.equalsIgnoreCase("SP") && reg2.equalsIgnoreCase("MR")) {
			this.setSp(Integer.parseInt(this.getMr()));
		}
		else if (reg1.equalsIgnoreCase("SP") && reg2.equalsIgnoreCase("DS")) {
			this.setSp(this.getDs());
		}
		else if (reg1.equalsIgnoreCase("SP") && reg2.equalsIgnoreCase("CS")) {
			this.setSp(this.getCs());
		}
		else if (reg1.equalsIgnoreCase("SP") && reg2.equalsIgnoreCase("IP")) {
			this.setSp(this.getIp());
		}
		else if (reg1.equalsIgnoreCase(reg2)) {
			
		}
		else if (reg2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) { 
			float reiksme = Float.parseFloat(reg2);
			if (reg1.equalsIgnoreCase("SP")) {
				this.setSp((int)reiksme);
			}
			else if (reg1.equalsIgnoreCase("CS")) {
				this.setCs((int)reiksme);
			}
			else if (reg1.equalsIgnoreCase("DS")) {
				this.setDs((int)reiksme);
			}
			else if (reg1.equalsIgnoreCase("MR")) {
				this.setMr(Integer.toString((int)reiksme));
			}
			else if (reg1.equalsIgnoreCase("IP")) {
				this.setIp((int)reiksme);
			}
			else {
				this.setPi(3);
			}
		}
		else {
			this.setPi(3);
		}
	}
	
	public void StepReading() {
		String sCurrentLine = null;
			if (br != null  && !this.isEnd) {
				if (this.getMode() == 0 && this.interrupting() == 0)
					this.setIp(this.getIp() + 1);
				try {
					if (this.getMode() == 0 && this.interrupting() == 0)
						sCurrentLine = this.br.readLine();
				} catch (IOException e) {
					System.out.println("Nepavyko nuskaityti failo");
				}
				if (sCurrentLine != null)
					System.out.println(sCurrentLine);
				String[] temp = null;
				if (sCurrentLine != null)
					temp = sCurrentLine.split("\\ ");
				if (this.isFirstWord) {
					if (this.isStart == false) {
						//System.out.println(temp[0]);
						if (temp[0].equalsIgnoreCase("$START")) {
							//pirmas zodis butinai turi buti $start
							this.isStart = true;
						}
						else {
							//vykdom halt ir nutraukiam visus veiksmus
							this.HALT();
						}
						this.isFirstWord = false;
					}
				}
				if (this.isStart && this.isFirstWord == false) {
					int interrupt = this.interrupting();
					if (interrupt == 0) {
						//interruptu nera vykdom programa
						if (temp[0].equalsIgnoreCase("$START") ) {
							
						}
						else if (temp[0].equalsIgnoreCase("$END")) {
							this.isEnd = true;
						}
						else {
							if (temp[0].equalsIgnoreCase("PRINT")) 
								this.printRegisterName = temp[1];
							int komanda = this.isCommand(temp[0]);
							if (komanda != 0) {
								switch (komanda) {
								case 1: this.ADDR(this.getRegisterValue(temp[1]), this.getRegisterValue(temp[2])); //addr
									break;
								case 2: this.SUBR(this.getRegisterValue(temp[1]), this.getRegisterValue(temp[2])); //subr
									break;
								case 3: this.MULR(this.getRegisterValue(temp[1]), this.getRegisterValue(temp[2])); //mulr
									break;
								case 4: this.DIVR(this.getRegisterValue(temp[1]), this.getRegisterValue(temp[2])); //divr
									break;
								case 5: this.PUSH(this.getRegisterValue(temp[1])); //push
									break;
								case 6: this.POP(temp[1]); //pop
									break;
								case 7: this.CMPCheck(temp[1], temp[2]); //cmpr
									break;
								case 8: this.JMP(Integer.parseInt(temp[1])); //jmp
									break;
								case 9: this.HALT(); //halt
									break;
								case 10: this.MOV(temp[1], temp[2]); //mov
									break;
								default: //System.out.println("Neatpazinta komanda");
				                	break;
								}
							}
							else {
								System.out.println("ne komanda");
							}
						}
					}
					else {
						//issaugome busena
						this.saveState();
						// tikrinam interruptus jungiam supervisor rezima
						
						if (interrupt == 1) { //IOI
							switch (this.getIoi()) {
								case 1: this.PRINT(this.getMr());
									break;
								case 2: this.READ();
									break;
								default: System.out.println("IOI apdorojimo klaida");
				                	break;
							}
						}
						else if (interrupt == 1) { //PI
							this.intPIValidation();
						}
						else if (interrupt == 2) { //TI
							this.HALT();
						}
						else {
						}
						//gryztame i buvusia busena ir toliau vykdome komandas
						this.returnState();
					}
				this.setTi(this.getTi() - 1);
			}
		}
	}
	
	public void intPIValidation() {
		int pi = this.getPi();
		if (pi == 1) {
			this.setMr("neteisingas adresas");
			this.channel.base(2, this.getMr());
		}
		if (pi == 2) {
			this.setMr("neteisingas operacijos kodas");
			this.channel.base(2, this.getMr());
		}
		if (pi == 3) {
			this.setMr("neteisingas priskyrimas");
			this.channel.base(2, this.getMr());
		}
		if (pi == 4) {
			this.setMr("perpildymas");
			this.channel.base(2, this.getMr());
		}
	}
	/*
	 * Funkcija turi issaugoti buse i ram atminti
	 */
	public void saveState() {
		//pirma issaugome visus registrus tada keiciame masinos busena
		
		this.setMode(1);
	}
	
	/*
	 * FUnkcija grazinanti pries tai buvusia busena ir sunaikinanti tai kas buvo irasyta i ram
	 */
	public void returnState() {
		//pirma pasiemame visus registrus, tada keiciame masinos busena
		
		
		this.setMode(0);
	}
	/*
	 * funkcija sukurianti virtualia ma�ina
	 */
	public void createVM() {
		//reikia i�saugoti ankstesn�s ma�inos darb�
		
		//toliau nusinulikam senuosius duomenis
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
		this.setTi(255);
		this.br = null;
		this.isFirstWord = true;
		this.isStart = false;
		this.isEnd = false;
		this.maxIP = 0;
		
		
	}

    public void ADDR(int value1, int value2){
    	int newValue = value1 + value2;
    	this.setMr(Integer.toString(newValue)); 	
	}
    
    public void SUBR(int value1, int value2){
    	int newValue = value1 - value2;
    	this.setMr(Integer.toString(newValue)); 
	}
    
    public void MULR(int value1, int value2){
    	int newValue = value1 * value2;
    	this.setMr(Integer.toString(newValue)); 
	}
    public void DIVR(int value1, int value2){
    	if (value2 == 0) {
    		this.setMr("0E"); 
    	}
    	else {
    		double newValue = value1 / value2;
        	this.setMr(Double.toString(newValue)); 
    	}
	}
    
    public void PUSH(int value1){
    	this.setSp(this.getSp() + 1);
    	
    }
	
    public void POP(String register){
    	this.setSp(this.getSp() - 1);
    	
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
