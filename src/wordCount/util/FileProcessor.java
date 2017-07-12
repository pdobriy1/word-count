package wordCount.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import wordCount.util.Logger;

public class FileProcessor {
	FileInputStream fstream;
	BufferedReader br;
	PrintStream psOut;
	
	public FileProcessor(String INPUTFILE,String outputFile) throws FileNotFoundException{
		fstream = new FileInputStream(INPUTFILE);
		br = new BufferedReader(new InputStreamReader(fstream));
		psOut = new PrintStream(new FileOutputStream(outputFile));
		Logger.writeMessage("Constructor invoked"+this.getClass().getName(),Logger.DebugLevel.CONSTRUCTOR);		
	}
	public String readLineFromFile() {
		try {
	        	return br.readLine();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return null;
	    }
	 public void fileClose() throws IOException{
	        // file close
	        br.close();
	    }

}
