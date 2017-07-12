Design Patterns



Author(s): Prateek dobriyal

PURPOSE:

This project is to calculate total word count,total number of distinct words,number of characters for an input file .


PERCENT COMPLETE:

I believe I have completed 100% of this project.

PATTERN USED:
Visitor pattern
Clone-observer pattern

REASONS:
As it is an itinerary of the list of things a student has to complete for his orientation 
and construct results based on the type of choice provided by the student builder pattern would be 
a wise choice to implement for this kind of scenario.

FILES:
1. wordCount.driver
	wordCount.driver.Driver.java
2. wordCount.dsForStrings
	wordCount.dsForStrings.redBlackNode.java
	wordCount.dsForStrings.redBlackTree.java
3. wordCount.util
	wordCount.util.FileProcessor.java
4. wordCount.visitors
	wordCount.visitors.PopulateTreeVisitor.java
	wordCount.visitors.backupVisitor.java
	wordCount.visitors.ObserverIn.java
	wordCount.visitors.SubjectIn.java
	wordCount.visitors.TreeVisitIn.java
	wordCount.visitors.TreeVisitorIn.java
	wordCount.visitors.wordCountVisitor.java

  README, the text file you are presently reading

DATASTRUCTURE:
Red Black Tree to store the words and to calculate the desired output 

source:
http://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html

Reasons:
Red black Tree is self balancing tree which helps in faster execution of insert,get and delete operation.
A red–black tree is a kind of self-balancing binary search tree. Each node of the binary tree has an extra bit, and that bit is often interpreted as the color (red or black) of the node. These color bits are used to ensure the tree remains approximately balanced during insertions and deletions.

The balancing of the tree is not perfect, but it is good enough to allow it to guarantee searching in O(log n) time, where n is the total number of elements in the tree. The insertion and deletion operations, along with the tree rearrangement and recoloring, are also performed in O(log n) time.


SAMPLE OUTPUT:
Total words : 5
Distinct words : 4
Number of characters : 35

TO COMPILE:
navigate to the krishnan_sriram_dobriyal_prateek/studentorientation and type in terminal:
 ant -buildfile build.xml all

## To clean:
ant -buildfile build.xml clean


TO RUN:

java Driver <your input file> <your output file> <number of iterations> 

## To run by specifying arguments from command line 
ant -buildfile build.xml run



BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

