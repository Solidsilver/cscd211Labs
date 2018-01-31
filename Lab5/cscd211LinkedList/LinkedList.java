/*
 * This LinkedList class was created by Luke Mattfeld
 * for CSCD211 at EWU
 */

package cscd211LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
	
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
	} // end of Node class'
	
	public LinkedList() {
		this.head = new Node();
		this.size = 0;
	}
	
	public LinkedList(java.lang.Comparable[] array) {
		this();
		this.addAll(0, array);
	}
	
	private Node head;
	private int size;

	
	public boolean add(Comparable item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		Node nn = new Node(item);
		
		Node cur = this.head.next;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = nn;
		this.size++;
		return true;
		
	}
	
	public boolean addAll(int index, Comparable[] array) {
		if (array = null) {
			throw new NullPointerException("Array cannot be null");
		}
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index must be within list size");
		}
		Node cur = this.head.next, prev = this.head;
		for (int scan = 0; scan < index; scan++) {
			prev = cur;
			cur = cur.next;
		}
		for (int idx = 0; idx < array.length; idx++) {
			prev.next = new Node(array[idx], cur);
			prev = prev.next;
         this.size++;
			
		}
		return true;
	}
	
	public void addFirst(Comparable item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		Node nn = new Node(item);
		this.head.next = new Node(item, this.head.next);
		this.size++;
	}
	
	public void clear() {
		this.head = new Node();
		this.size = 0;
	}
	
	public Comparable get(int index) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index must be within list size");
		}
		Node cur = this.head.next;
		for (int scan = 0; scan < index; scan++) {
			cur = cur.next;
		}
		return cur.data;
	}
	
	public Comparable getLast() {
		if (this.size == 0) {
			throw new NoSuchElementException("List is empty");
		}
		Node cur = this.head.next;
		while (cur.next != null) {
			cur = cur.next;
		}
		return cur.data;
	}
	
	public Comparable remove() {
		if (this.size == 0) {
			throw new NoSuchElementException("List is empty");
		}
		Node cur = this.head.next;
		this.head.next = cur.next;
		cur.next = null;
    	this.size--;
		return cur.data;
	}
	
	public Comparable remove(int index) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index must be within list size");
		}
		Node cur = this.head.next, prev = this.head;
		for (int scan = 0; scan < index; scan++) {
			prev = cur;
			cur = cur.next;
		}
		prev.next = cur.next;
		cur.next = null;
    	this.size--;
		return cur.data;
	}
	
	
	public Comparable removeLast() {
		if (this.size == 0) {
			throw new NoSuchElementException("List is empty");
		}
		Node cur = this.head.next, prev = this.head;
		while (cur.next != null) {
			prev = cur;
			cur = cur.next;
		}
		prev.next = null;
    	this.size--;
		return cur.data;
	}
	
	public int size() {
		return this.size;
	}
	
	public Comparable[] toArray() {
		Comparable[] arr = new Comparable[this.size];
		Node cur = this.head.next;
		for (int index = 0; index < this.size; index++) {
			arr[index] = cur.data;
			cur = cur.next;
		}
		return arr;
	}
	
	@Override
	public String toString() {
		if (this.size == 0) {
			return "Empty List";
		} else {
			Comparable[] list = this.toArray();
			String comp = "";
			for (int scan = 0; scan < this.size; scan++) {
				comp = comp + list[scan] + ", ";
			}
			return comp;
		}
	}
	

} // end of LinkedList class
