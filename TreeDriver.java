package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The TreeDriver class utilizes the Tree and TreeNode classes to implement an automated help service. 
 * 
 * Extra Credit: 
 * 	The first extra credit requirement was done by creating an array within each TreeNode that could 
 * 	contain the children. Methods were created so that they could manipulate the array when adding, retrieving, etc. children.
 * 	The second extra credit was done by creating a getParent() method in the TreeNode class that returned the parent of the 
 * 	current node by using the label of the node. 
 * 	
 * @author Samuel Sundararaman 
 * 		e-mail: samuel.sundararaman@stonybrook.edu 
 * 		Stony Brook ID: 111352739
 */
public class TreeDriver {

	private static Scanner scanner; // Scanner to take in user input. 

	/**
	 * Main method to take in user input and operate the help service. 
	 * 
	 * @param args
	 * @throws FileNotFoundException Throws if file to read tree from is not found. 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Tree question = null;;
		TreeNode root = null;
		scanner = new Scanner(System.in);
		String input = "Z";
		
		while (!input.equals("Q")) {
			System.out.print("L - Load a Tree. \n" + "H - Begin a Help Session. \n"
					+ "T - Traverse the tree in preorder. \n" + "Q - Quit \n" + "Choice> ");
			input = scanner.nextLine();

			if (input.equals("L")) {
				String[] info;
				String parentLabel;
				String label;
				String prompt;
				String message;
				String filename;
				System.out.println("Enter the file name> ");
				filename = "D:\\Samuel\\eclipse-workspace\\cse214\\src\\hw4\\testCase.txt";
				File file = new File(filename);
				Scanner fileReader = new Scanner(file);
				label = fileReader.nextLine();
				prompt = fileReader.nextLine();
				message = fileReader.nextLine();
				info = fileReader.nextLine().split(" ");
				root = new TreeNode(label,prompt,message);
				question = new Tree(label,prompt,message);
				
				while(fileReader.hasNextLine()) {
					if(Integer.parseInt(info[1])>0) {
						question.getNodeReference(label).setNumChildren(Integer.parseInt(info[1]));
						for(int i=0;i<Integer.parseInt(info[1]);i++) {
							parentLabel = label;
							String lab = fileReader.nextLine();
							prompt = fileReader.nextLine();
							message = fileReader.nextLine();
							question.addNode(lab, prompt, message, parentLabel);
						}
					
					}
					if(fileReader.hasNextLine()) {
					info = fileReader.nextLine().split(" ");
					label = info[0];
					}
				}
				
				System.out.println("Tree created successfully!");
				System.out.println(" ");
				fileReader.close();

			}
			if(input.equals("H")) {
				TreeNode temp = root;
				String in = "-1";
				question.beginSession();
				
				while(Integer.parseInt(in) != 0) {
					System.out.println(" ");
					System.out.println(temp.getMessage());
					
					for(int i=0;i<question.getNodeReference(temp.getLabel()).getNumChildren();i++) {
						System.out.println((i+1)+" "+question.getNodeReference(temp.getLabel()).getChild(i).getPrompt());
					}
					System.out.println("B Go Back to previous menu.");
					System.out.println("0 Exit Session.");
					System.out.print("Choice> ");
					in = scanner.nextLine();
					
					while(in.equals("B")) {
						
						temp = question.getNodeReference(question.getNodeReference(temp.getLabel()).getParent());
						
						if(temp==root) {
							System.out.println("Cannot go back further.");
							System.out.println(" ");
						}
						System.out.println(temp.getLabel());
						System.out.println(" ");
						System.out.println(temp.getMessage());
						for(int i=0;i<question.getNodeReference(temp.getLabel()).getNumChildren();i++) {
							System.out.println((i+1)+" "+question.getNodeReference(temp.getLabel()).getChild(i).getPrompt());
						}
						System.out.println("B Go Back to previous menu.");
						System.out.println("0 Exit Session.");
						System.out.print("Choice> ");
						in = scanner.nextLine();
					}
					
					if(Integer.parseInt(in) != 0) {
						temp = question.getNodeReference(temp.getLabel()).getChild(Integer.parseInt(in)-1);	
					}
					if(question.getNodeReference(temp.getLabel()).isLeaf()) {
						System.out.println(temp.getMessage());
						in = "0";
					}
					
				}
				System.out.println("Thank you for using our automated help system.");
				System.out.println(" ");
				scanner.nextLine();
				input = "Z";
			}
			if(input.equals("T")) {
				System.out.println("Traversing the tree in preorder:" );
				question.preOrder(question.getNodeReference(root.getLabel()));
			}
			

		}
		scanner.close();
		System.out.println("Thank you for using automated help services!");
		System.exit(0);

	}

}
