package wordCount.visitors;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

import wordCount.dsForStrings.redBlackTree;
import wordCount.util.FileProcessor;


public class PopulateTreeVisitor implements TreeVisitorIn {

	private String inputFile,outputFile;
	
	public PopulateTreeVisitor(String iNPUTFILE,String oUTPUTFILE) {
		inputFile = iNPUTFILE;
		outputFile = oUTPUTFILE;
	}
	
	@Override
    public void visit(redBlackTree tree) {


        FileProcessor fp = null;

        try {
            fp = new FileProcessor(inputFile,outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String input = fp.readLineFromFile();

        while (input != null) {
           String[] array = input.split("\\s+");
            for (String word : array) {
                tree.insertString(word);
            }
            input = fp.readLineFromFile();
        }
    }

}
