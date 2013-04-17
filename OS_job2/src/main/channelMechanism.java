package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class channelMechanism {
	
	public String base(int channelId, String outMessage) {
		String s = null;
		if (channelId == 1) {
			s = this.input();
		}
		else if (channelId == 2) {
			this.output(outMessage);
		}
		else {
			return "10";
		}
		return s;
	}
	
	public String input() {
		String s = null;
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    this.base(2, "Iveskite teksta");
		    s = bufferRead.readLine();
		}
		catch(IOException e)
		{
			this.base(2, "Ivedimo bibliotekos klaida");
		}
		return s;
	}
	
	
	public void output(String outText) {
		System.out.println(outText);
	}
	
}
