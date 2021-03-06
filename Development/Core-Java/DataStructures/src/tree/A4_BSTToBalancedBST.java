package tree;

import java.util.*;

public class A4_BSTToBalancedBST {
	public static void main(String[] args) {
		
		/* Constructed skewed binary tree is 
				10 
				/ 
			   8 
			  / 
			 7 
			/ 
		   6 
		  / 
		 5 
		*/
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(7);
		tree.root.left.left.left = new Node(6);
		tree.root.left.left.left.left = new Node(5);

		tree.root = tree.buildTree(tree.root);
		System.out.println("Preorder traversal of balanced BST is :");
		tree.preOrder(tree.root);
	}
}

class BinaryTree {
	Node root;

	void storeBSTNodes(Node root, Vector<Node> nodes) {
		// Base case
		if (root == null)
			return;

		storeBSTNodes(root.left, nodes);
		nodes.add(root);
		storeBSTNodes(root.right, nodes);
	}

	Node buildTreeUtil(Vector<Node> nodes, int start, int end) {
		if (start > end)
			return null;

		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		Node node = nodes.get(mid);

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		node.left = buildTreeUtil(nodes, start, mid - 1);
		node.right = buildTreeUtil(nodes, mid + 1, end);

		return node;
	}

	Node buildTree(Node root) {
		Vector<Node> nodes = new Vector<Node>();
		storeBSTNodes(root, nodes);

		int n = nodes.size();
		return buildTreeUtil(nodes, 0, n - 1);
	}

	/* Function to do preorder traversal of tree */
	void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
}

