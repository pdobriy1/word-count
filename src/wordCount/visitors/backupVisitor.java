package wordCount.visitors;

import wordCount.dsForStrings.redBlackTree;

public class backupVisitor implements TreeVisitorIn{

	public backupVisitor() {
		// TODO Auto-generated constructor stub
	}
	public void visit(redBlackTree tree) {
		try {
			tree.cloneNode(tree.getRootNode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
