package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("null value");
		}
		else {
			LLNode<E> newNode = new LLNode<E>(element);
			newNode.prev = tail.prev;
			newNode.next = tail;
			tail.prev.next = newNode;
			tail.prev = newNode;
			size++;
		}
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		LLNode<E> tofound = head;
		if (index<0) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		else {
			for (int i=0; i<index+1; i++) {
				if (tofound.next.data != null) {
					tofound = tofound.next;
			    }
			    else {
				    throw new IndexOutOfBoundsException("index out of bounds");
			    }
		    }
		}
		return tofound.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element)
	{
		// TODO: Implement this method
		LLNode<E> prevNode = head;
		if (index < 0) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		if (element == null) {
			throw new NullPointerException("null value");
		}
		else {
			for (int i=0; i<index; i++) {
				if (prevNode.next.data != null) {
					prevNode = prevNode.next;
				}
				else {
					throw new IndexOutOfBoundsException("index out of bounds");
				}
			}
			LLNode<E> newNode = new LLNode<E>(element);
			newNode.next = prevNode.next;
			newNode.prev = prevNode.next.prev;
			newNode.next.prev = newNode;
			prevNode.next = newNode;
			size++;
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> toRemove = head;
		if (index < 0) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		else {
			for (int i=0; i<index+1; i++) {
				if (toRemove.next.data != null) {
					toRemove = toRemove.next;
				}
				else {
					throw new IndexOutOfBoundsException("index out of bounds");
				}
			}
			toRemove.prev.next = toRemove.next;
			toRemove.next.prev = toRemove.prev;
			toRemove.prev = null;
			toRemove.next = null;
			size--;
		}
		return toRemove.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		// TODO: Implement this method
		LLNode<E> toSet = head;
		if (index < 0) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		if (element == null) {
			throw new NullPointerException("null value");
		}
		else {
			LLNode<E> newNode = new LLNode<E>(element);
			for (int i=0; i<index+1; i++) {
				if (toSet.next.data != null) {
					toSet = toSet.next;
				}
				else {
					throw new IndexOutOfBoundsException("index out of bounds");
				}
			}
			newNode.prev = toSet.prev;
			newNode.next = toSet.next;
			newNode.prev.next = newNode;
			newNode.next.prev = newNode;
			toSet.prev = null;
			toSet.next = null;
		}
		return toSet.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
