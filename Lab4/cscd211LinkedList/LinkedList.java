/*
 * This LinkedList class was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
	
	// Nodes of the List
	private static class Node {
		
		public Comparable data;
		public Node next;
		
		public Node() {
			this(null, null);
		}
		public Node(final Comparable d) {
			this(d, null);
		}
		public Node(final Comparable d, final Node n) {
			this.data = d;
			this.next = n;
		}
	} // end of Node class
	
	private Node head;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	// Returns the size of the list
	public int size() {
			return this.size;
	}
	
	// Clears the list
	public void clear() {
		this.head = null;
		this.size = 0;
	}
	
	// Adds the given item to the begining of the list
	public void addFirst(final Comparable item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		Node nn = new Node(item);
		this.head = new Node(item, this.head);
		this.size++;
	}
	
	// Returns the index value of teh given item in the list
	public int indexOf(final Comparable item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		Node cur = this.head;
		for (int count = 0; cur.next != null; count++) {
			if (cur.data.compareTo(item) == 0) {
				return count;
			} else {
				cur = cur.next;
			}
		}
		return -1;
	}
	
	// Removes the first item in the list
	public Comparable removeFirst() {
		if (this.size == 0) {
			throw new NoSuchElementException("List is Empty");
		} else {
			Node cur = this.head;
			this.head = cur.next;
			Comparable removed = cur.data;
			cur.next = null;
			cur.data = null;
			this.size--;
			return removed;
		}
	}
	
	// Removes the last item in the list
	public Comparable removeLast() {
		if (this.size == 0) {
			throw new NoSuchElementException("List is Empty");
		}
		Node cur = this.head;
		for (int count = 0; count < this.size - 2; count++) {
			cur = cur.next;
		}
		Comparable removed = cur.next.data;
		cur.next = null;
		this.size --;
		return removed;
	}
	
	// Removes an item in the list by index
	public Comparable remove(final int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (index == 0) {
			return this.removeFirst();
		}
		Node cur = this.head, prev = null;
		for (int count = 0; count < index; count++) {
			prev = cur;
			cur = cur.next;
		}
		prev.next = cur.next;
		Comparable removed = cur.data;
		cur.next = null;
		cur.data = null;
		this.size --;
		return removed;
	}
	
	// Adds the given item to list at the given index
	public void add(final int index, final Comparable item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		if (index < 0 || index > this.size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (index == 0) {
				addFirst(item);
		} else {
			Node cur = this.head;
			for (int count = 0; count < index - 1; count++) {
					cur = cur.next;
			}
			cur.next = new Node(item, cur.next);
			this.size++;
		}
	}
	
	// Removes the the given item from the list the last time it shows up
	public boolean removeLastOccurrence(final Comparable item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		Node cur = this.head;
		int lastIx = -1;
		for (int count = 0; cur != null; count++) {
			if (cur.data.compareTo(item) == 0) {
				lastIx = count;
			}
			cur = cur.next;
		}
		if (lastIx > -1) {
			this.remove(lastIx);
			return true;
		} else return false;
	}
	
	// Removes the given item the first time it shows up
	public boolean removeFirstOccurrence(final Comparable item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		int ix = this.indexOf(item);
		if (ix > 0) {
			this.remove(ix);
			return true;
		}
		return false;
	}
	
	// Adds the given item to the beginning of the list
	public void addLast(final Comparable item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		Node nn = new Node(item);
		if (this.size == 0) {
			this.addFirst(item);
		} else {
			Node cur = this.head;
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = nn;
			this.size++;
		}
		
	}

	// Returns a string of the data in each item of the list
	// Separated by ", "
	@Override
	public String toString() {
		if (this.size == 0) {
			return "Empty List";
		} else {
			String str = "";
			Node cur = this.head;
			while (cur != null) {
				str += cur.data + ", ";
				cur = cur.next;
			}
			return str;
		}
	}
	
	// Checks whether a list contains the given item
	public boolean contains(final Comparable item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		if (this.indexOf(item) > 0) {
			return true;
		}
		return false;
	}

} // end of LinkedList class
