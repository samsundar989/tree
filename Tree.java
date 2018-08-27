package hw4;

/**
 * The Tree class implements a tree with a reference to a root TreeNode object. 
 * 
 * 
 * @author Samuel Sundararaman 
 * 		e-mail: samuel.sundararaman@stonybrook.edu 
 * 		Stony Brook ID: 111352739
 */
public class Tree {

	private TreeNode root; // Reference to the root node of the Tree

	/**
	 * Constructor for the Tree, initializes the root TreeNode.
	 * 
	 * @param label Label for the root node.
	 * @param prompt Prompt for the root node.
	 * @param message Message for the root node. 
	 */
	public Tree(String label, String prompt, String message) {
		root = new TreeNode(label, prompt, message);
	}

	/**
	 * Adds a node to the tree.
	 * 
	 * @param label Label for the new node.
	 * @param prompt Prompt for the new node. 
	 * @param message Message for the new node.
	 * @param parentLabel Label of the parent of the new node. 
	 * @return True if the new node was added successfully, otherwise false.
	 */
	public boolean addNode(String label, String prompt, String message, String parentLabel) {
		TreeNode parent;
		if(parentLabel.equals(root.getLabel())) {
			parent = root;
			
		}
		else {
			
			parent = this.getNodeReference(parentLabel);
		}
		
		TreeNode child = new TreeNode(label, prompt, message);
		if (parent.setChild(child)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the node reference of the passed node label. 
	 * 
	 * @param label Label of the node to retrieve.
	 * @return TreeNode reference to TreeNode with passed label.
	 */
	public TreeNode getNodeReference(String label) {
		TreeNode temp = root;
		String[] find = label.split("-");
		if(label.equals(root.getLabel().toString())||label.equals("root")) {
			return temp;
		}
		for (int i = 0; i < find.length; i++) {
			temp = temp.getChild(Integer.parseInt(find[i].trim())-1);
		}
		return temp;

	}

	/**
	 * Prints the tree in preorder.
	 * 
	 * @param node TreeNode to start printing the Tree in preorder.
	 */
	public void preOrder(TreeNode node) {
		
		if(node==root) {
			System.out.println("Label: "+node.getLabel() + "\n" + "Prompt: "+node.getPrompt() + "\n"
					+ "Message: "+node.getMessage());
		}
		if(!node.isLeaf()) {
			for (int i = 0; i < node.getNumChildren(); i++) {
				System.out.println("Label: "+node.getChild(i).getLabel() + "\n" + "Prompt: "+node.getChild(i).getPrompt() + "\n"
						+ "Message: "+node.getChild(i).getMessage());
				System.out.println(" ");
				this.preOrder(node.getChild(i));
			}
		}

	}

	/**
	 * Begins the question and answer session. 
	 */
	public void beginSession() {
		System.out.println("Help session starting... ");
	}

}
