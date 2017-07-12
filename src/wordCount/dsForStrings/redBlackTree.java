package wordCount.dsForStrings;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import wordCount.visitors.TreeVisitIn;
import wordCount.visitors.TreeVisitorIn;
import wordCount.visitors.wordCountVisitor;
import wordCount.dsForStrings.redBlackNode;
public class redBlackTree implements TreeVisitIn{

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private redBlackNode rootNode;
	private int totalWords = 0; //total words
	private int distinctWords = 0; //number of distinct words
	private int numChars = 0;//no of characters (not distinct words)
	
	public redBlackNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(redBlackNode rootNode) {
		this.rootNode = rootNode;
	}
	/*
	 * creating the construcctor for the redblack tree
	 */
	public redBlackTree(){
		
	}
	/*
	 * checks the status for the node
	 * if it is red or black
	 * @return true or false
	 */
	private boolean isRed(redBlackNode node){
		if(node != null){
			return (node.getColor() == RED);
		}
		else 
			return false;
	}
	// number of node in subtree rooted at x; 0 if x is null
	private int size(redBlackNode node) {
        if (node == null) return 0;
        return node.getSubtreeCount();
    } 
	
	/**
     * @return
     */
	public int size() {
        return size(rootNode);
    }
	/*
	 * if tree is empty
	 * @return
	 */
	public boolean isEmpty(){
		return rootNode == null;		
	}
	
	/*
	 * insert the word/string in the tree
	 */
	public void insertString(String stringIn){
		if(stringIn == null){
			return ;
		}
		else
			rootNode = putString(rootNode,stringIn);/* insert string in the node using putString */
			rootNode.setColor(BLACK);//change the color of the node
	}
	private redBlackNode putString(redBlackNode node, String stringIn) {
		// TODO Auto-generated method stub
		int compareStringVal;
//		System.out.println(stringIn);
		if(node == null){
			/*
			 * creating new node
			 */
			return new redBlackNode(stringIn, RED, 1, 1);
		}
		else{
		
			compareStringVal = stringIn.compareTo(node.getInputString());
			/*comparing the strings
			 * 
			 */
			
			if(compareStringVal > 0){
				node.setRight(putString(node.getRight(), stringIn));
			}else if(compareStringVal < 0){
				node.setLeft(putString(node.getLeft(), stringIn));
			}else if(compareStringVal ==0){
				node.incrementCount();
			}
			
			/*
			 * checking if the node is red and rotating to 
			 * balanace the tree
			 */
			if (isRed(node.getRight()) && !isRed(node.getLeft()))
				node = rotateLeft(node);
			if (isRed(node.getLeft())  &&  isRed(node.getLeft().getLeft()))
				node = rotateRight(node);
			if (isRed(node.getLeft())  &&  isRed(node.getRight()))     
				flipColors(node);
			
			node.setSubtreeCount(size(node.getLeft()) + size(node.getRight()) + 1);

		}
		return node;
	}
	
	/**
	 * Traverse inorder through the Tree
	 */
	public void inorderTraversal(FileWriter fw) {
		inorderTraversalHelper(this.rootNode);
		BufferedWriter writer = new BufferedWriter(fw);
		write(writer,"Total words : "+totalWords+"\n");
		write(writer,"Distinct words : "+distinctWords+"\n");
		write(writer,"Number of characters : "+numChars);
		close_write(writer);

	}

	/**
	 * Helper method for inorder traversal
	 * @param node = root
	 */
	private void inorderTraversalHelper(redBlackNode node) {
		
		if (node != null) {
			inorderTraversalHelper(node.getLeft());
//			System.out.println(node.getCountWord()+ ""+node.getInputString());
			distinctWords++;
			totalWords += node.getCountWord();
			numChars += (node.getInputString().length())*node.getCountWord();
//			System.out.println(distinctWords);
//			System.out.println(totalWords);
//			System.out.println(numChars);
			inorderTraversalHelper(node.getRight());
//			System.out.println(node.getCountWord()+ ""+node.getInputString());

		}
	}

	private void write(BufferedWriter bw, String data) {
		try 
		{
			bw.write(data);
		} 
		catch (IOException e) 
		{
			System.out.println("Error while writing data to file: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally{
			
		}
	}
	
	private void close_write(BufferedWriter bw)
	{
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
		
	}
	/**
	 * Inverts the color of the node
	 * @param node = input node
	 */
	private void flipColors(redBlackNode node) {
		// TODO Auto-generated method stub
		node.setColor(!(node.getColor()));
		node.getLeft().setColor(!(node.getLeft().getColor()));
		node.getRight().setColor(!(node.getRight().getColor()));
	}
	/**
	 * Perform Right rotation on the node in RedBlack Tree
	 * @param node = node
	 * @return node
	 */
	private redBlackNode rotateRight(redBlackNode node) {
		// TODO Auto-generated method stub
		redBlackNode x = node.getLeft();
		node.setLeft(x.getRight()); // h.left = x.right;
		x.setRight(node); // x.right = h;
		x.setColor(x.getRight().getColor()); // x.color = x.right.color;
		x.getRight().setColor(RED); // x.right.color = RED;
		x.setSubtreeCount(node.getSubtreeCount());
		node.setSubtreeCount(size(node.getLeft()) + size(node.getRight()) + 1);
		return x;
	}
	/**
	 * Perform Left rotation on the node in RedBlack Tree
	 * @param node = node
	 * @return node
	 */
	private redBlackNode rotateLeft(redBlackNode node) {
		// TODO Auto-generated method stub
		redBlackNode x = node.getRight();
		node.setRight(x.getLeft());
		x.setLeft(node);
		x.setColor(x.getLeft().getColor());
		x.getLeft().setColor(RED);
		x.setSubtreeCount(node.getSubtreeCount());
		node.setSubtreeCount(size(node.getLeft()) + size(node.getRight()) + 1);
		return x;		
	}
	

	@Override
	public void accept(TreeVisitorIn visitor) {
		visitor.visit(this);
	}

	public String printRoot() {
		return this.rootNode.getInputString();
	}
	
	public redBlackNode cloneNode(redBlackNode node) throws CloneNotSupportedException{
		redBlackNode cloneNode = null;
		if(cloneNode != null){
			cloneNode = (redBlackNode)node.clone();
			cloneNode.setLeft(null);
			cloneNode.setRight(null);
		}
		return node;
		
	}
}
