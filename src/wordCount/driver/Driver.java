/**
 * 
 */
package wordCount.driver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.TreeVisitIn;
import wordCount.visitors.TreeVisitorIn;
import wordCount.visitors.backupVisitor;
import wordCount.visitors.wordCountVisitor;
import wordCount.dsForStrings.redBlackTree;

/**
 * @author prateek
 *
 */
public class Driver {

	public static String INPUTFILE;
	public static String OUTPUTFILE;
	public static int NUMBER_OF_ITERATIONS = 0;
	public static int debugVALUE;
	
	public static void main(String[] args) {
		/*
		 * validating the number of arguments
		 */
		
		if(args.length < 3 || args.length > 3){
			System.out.println("Number of arguments is inadequate,please check the number of arguments!!");
			System.exit(1);
		}
		INPUTFILE = args[0].toString();
		OUTPUTFILE = args[1].toString();
		try {		
			NUMBER_OF_ITERATIONS = Integer.parseInt(args[2]);

		} catch (NumberFormatException nfe) {
			System.out.println("number format exception");
			nfe.printStackTrace();
			System.exit(1);
		}finally{
			
		}

		/*
		 * creating the element
		 */
		
		/*
		 * creating two visitor instance
		 */
		long startTime = System.currentTimeMillis();

		TreeVisitIn rbTree = null;
		
		TreeVisitorIn populate = new PopulateTreeVisitor(INPUTFILE,OUTPUTFILE);
		TreeVisitorIn wordCount = new wordCountVisitor(OUTPUTFILE);
		for (int i = 0; i < NUMBER_OF_ITERATIONS; i++){
			rbTree = new redBlackTree();
			rbTree.accept(populate );
			rbTree.accept(wordCount);
			
		}
		long finishTime = System.currentTimeMillis();
		long total_time = (finishTime - startTime) / NUMBER_OF_ITERATIONS;
		System.out.println("Total time for " + NUMBER_OF_ITERATIONS + " iteration is: " + total_time + " ms.");
		
		TreeVisitorIn cloneVisitor = new backupVisitor();
		rbTree.accept(cloneVisitor);
		
	}

}
