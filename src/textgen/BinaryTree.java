package textgen;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable<? super E>> {
	TreeNode<E> root;
	
	private void preOrder(TreeNode<E> node) {
		if (node != null) {
			node.visit();
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	
	private void postOrder(TreeNode<E> node) {
		if (node != null) {
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			node.visit();
		}
	}
	
	private void inOrder(TreeNode<E> node) {
		if (node != null) {
			inOrder(node.getLeftChild());
			node.visit();
			inOrder(node.getRightChild());
		}
	}
	
	public void levelOrder() {
		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<E> curr = q.remove();
			if(curr != null) {
				curr.visit();
				q.add(curr.getLeftChild());
				q.add(curr.getRightChild());
			}
		}
	}
	
	public boolean contains(E toFind) {
		TreeNode<E> curr = root;
		while (curr != null) {
			int comp = toFind.compareTo(curr.getData());
			if (comp < 0) {
				curr = curr.getLeftChild();
			}
			else if (comp > 0) {
				curr = curr.getRightChild();
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	public boolean insert(E toInsert) {
		TreeNode<E> curr = root;
		int comp = toInsert.compareTo(curr.getData());
		while (comp < 0 && curr.getLeftChild() != null ||
				comp > 0 && curr.getRightChild() != null) {
			if (comp < 0) {
				curr = curr.getLeftChild();
			}
			else {
				curr = curr.getRightChild();
			}
			comp = toInsert.compareTo(curr.getData());
		}
		if (comp < 0) {
			curr.addLeftChild(toInsert);
		}
		else if (comp > 0) {
			curr.addRightChild(toInsert);
		}
		else {
			return false;
		}
		return true;
	}
	
	public boolean delete(E toDelete) {
		
		
		return false;
	}

}

class TreeNode<E> {
	private E value;
	private TreeNode<E> parent;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	public TreeNode(E val, TreeNode<E> par) {
		this.value = val;
		this.parent = par;
		this.left = null;
		this.right = null;
	}
	
	public E getData() {
		return this.value;
	}
	
	public TreeNode<E> addLeftChild(E val){
		this.left = new TreeNode<E>(val, this);
		return this.left;
	}
	
	public TreeNode<E> addRightChild(E val) {
		this.right = new TreeNode<E>(val, this);
		return this.right;
	}
	
	public TreeNode<E> getLeftChild(){
		return this.left;
	}
	
	public TreeNode<E> getRightChild() {
		return this.right;
	}
	
	public void visit() {
		
	}
}
