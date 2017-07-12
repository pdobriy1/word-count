package wordCount.dsForStrings;

import java.util.ArrayList;
import java.util.Observer;

import wordCount.visitors.ObserverIn;
import wordCount.visitors.SubjectIn;

public class redBlackNode implements Cloneable,SubjectIn,ObserverIn{
	private redBlackNode left,right; //left and right node of parent node
	private static String inputString; //input string
	private Boolean color; //red or black
	private int countWord; //frequency of the word or string appears
	private int subtreeCount; //subtree count
	private ArrayList<ObserverIn> observers = new ArrayList<ObserverIn>();
	

	/*
	 * constructor to create a new node in red black tree
	 * @param StringIn = read word from file
	 * @param colorIn = intital color/status of the node
	 * @param countIn = frequency of the word/string
	 * @param subtreecountIn = count the subtree
	 */
	public redBlackNode(String StringIn,boolean colorIn,int countIn,int subtreeCountIn){
		inputString = StringIn;
		color = colorIn;
		countWord = countIn;
		subtreeCount = subtreeCountIn;
	}

	public redBlackNode getLeft() {
		return left;
	}

	public void setLeft(redBlackNode left) {
		this.left = left;
	}

	public redBlackNode getRight() {
		return right;
	}

	public void setRight(redBlackNode right) {
		this.right = right;
	}

	public static String getInputString() {
		return inputString;
	}

	

	/*
	 * getter method to set the color of node
	 */
	public Boolean getColor() {
		return color;
	}

	/*
	 * setter method to get the color of the node
	 */
	public void setColor(Boolean colorIn) {
		color = colorIn;
	}

	/*
	 * getter method to count the word
	 * @return countWord
	 */
	public int getCountWord() {
		return countWord;
	}

	/*
	 * setter method to count the word
	 */
	public void setCountWord(int countWord) {
		this.countWord = countWord;
	}

	/*
	 * return the count of subtree
	 * @return the count of subtree
	 */
	public int getSubtreeCount() {
		return subtreeCount;
	}

	/*
	 * setter method for subtree count
	 */
	public void setSubtreeCount(int subtreeCountIn) {
		subtreeCount = subtreeCountIn;
	}
	public void incrementCount(){
		countWord += 1;
	}

	public Object clone() throws CloneNotSupportedException{
		return super.clone();
		
	}
	@Override
	public void notifyObserver(int updateValueIn) {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			 this.observers.get(i).update(updateValueIn);
			 }
	}

	@Override
	public void registerObserver(ObserverIn o) {
		// TODO Auto-generated method stub
		this.observers.add(o);
	}

	@Override
	public void removeObserver(ObserverIn o) {
		// TODO Auto-generated method stub
		this.observers.remove(o);
	}


	@Override
	public void update(int count) {
		// TODO Auto-generated method stub
		this.setCountWord(this.getCountWord()+count);
	}
	
}
