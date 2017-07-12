package wordCount.visitors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import wordCount.dsForStrings.redBlackTree;
import wordCount.dsForStrings.redBlackNode;

public class wordCountVisitor implements TreeVisitorIn {

	private String resultString;
	private String outputFile;
	private int totalWords = 0; //total words
	private int distinctWords = 0; //number of distinct words
	private int numChars = 0;//no of characters (not distinct words)
	public wordCountVisitor(String outputFileIn) {
		// TODO Auto-generated constructor stub
		outputFile = outputFileIn;
	}

	@Override
	public void visit(redBlackTree tree) {
		// TODO Auto-generated method stub
		File f = new File(outputFile);
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
		} catch (FileNotFoundException fnf){
			System.out.println("File not found"+fnf);
			fnf.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
		if(tree.isEmpty())
			return ;
		else{
				tree.inorderTraversal(fw);
		}
		

	}
	

}
