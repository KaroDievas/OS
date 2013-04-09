package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class channelMechanism {
	
	int channelId1 = 0;
	
	public String base(int channelId, String outMessage) {
		String s = null;
		if (channelId1 == 1) {
			s = this.input();
		}
		else if (channelId1 == 2) {
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
		    s = bufferRead.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	
	public void output(String outText) {
		System.out.println(outText);
	}
	
}
