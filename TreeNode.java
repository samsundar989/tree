package hw4;

/**
 * The TreeNode Class implements a TreeNode object which defines the methods and variables
 * for a node in the automated help tree.
 * 
 * 
 * 
 * @author Samuel Sundararaman 
 * 		e-mail: samuel.sundararaman@stonybrook.edu 
 * 		Stony Brook ID: 111352739
 */
public class TreeNode {
	
	private TreeNode[] nodes; // Array containing children of current node
	private String label; // Name of current node
	private String message; // Message which current node contains
	private String prompt; // Prompt which current node contains 
	
	/**
	 * Constructs a TreeNode object with a label, message, and prompt
	 * 
	 * @param lab Label which indicates the node's position in the tree
	 * @param mes Message which is displayed to the user
	 * @param p Prompt which is displayed to the user
	 */
	public TreeNode(String lab, String p, String mes) {
		this.label = lab;
		this.message = mes;
		this.prompt = p;
		
		
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String getPrompt() {
		return this.prompt;
	}
	
	public String getParent() {
		StringBuilder sb = new StringBuilder();
		String[] size = this.label.split("-");
		System.out.println("length = " + label.trim().length());
		if(size.length==1 || this.label.equals("root")) {
			sb.append("root");
		}
		else {
			for(int i=0;i<label.trim().length()-2;i++) {
				sb.append(label.charAt(i));
			}
		}
		System.out.println("testing = "+sb.toString());
		return sb.toString();
	}
	
	public TreeNode getChild(int index) {
		return this.nodes[index];
	}
	
	public int getNumChildren() {
		return this.nodes.length;
	}
	
	public void setNumChildren(int num) {
		this.nodes = new TreeNode[num];
	}
	public void setLabel(String newLabel) {
		label = newLabel;
	}

	public void setMessage(String newMessage) {
		message = newMessage;
	}
	
	public void setPrompt(String newPrompt) {
		prompt = newPrompt;
	}
	
	public boolean setChild(TreeNode child) {
		for(int i=0;i<this.nodes.length;i++) {
			if(this.nodes[i]==null) {
				this.nodes[i] = child;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Determines whether the current node is a leaf
	 * 
	 * @return True if current node is a leaf, otherwise return false.
	 */
	public boolean isLeaf() {
		if(this.nodes==null || this.nodes.length==0) {
			return true;
		}
		else {
			return false;
		}
	}
}
