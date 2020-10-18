package com.MyHashMap;

public class MyLinkedList<K> {
	public INode<K> head;
	public INode<K> tail;

	/**
	 * Constructor
	 */
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	

	/**
	 * Add element at last
	 * @param newNode
	 */
	public void append(INode<K> newNode) {
		if (this.tail == null) {
			this.tail = newNode;
		}
		if(this.head == null) {
			this.head = newNode;
		}else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	
	/**
	 * Search the element in linked list
	 * @param key
	 * @return
	 */
	public INode<K> search(K key) {
		INode tempNode = head ;
		while (tempNode != null && tempNode.getNext() != null) {
			if(tempNode.getKey().equals(key)) {
				return tempNode;
		}
			tempNode =tempNode.getNext();
		}
		return null;
	}
	
	/**
	 * remove the element from list
	 * @param key
	 */
	public void  delete(INode myMapNode){
		INode tempNode = head;
		INode previous = head;
		while (!tempNode.getKey().equals(myMapNode.getKey())) {
			previous = tempNode;
			tempNode = tempNode.getNext();
		}
		previous.setNext(tempNode.getNext());
	}

	public void print() {
		System.out.println("Nodes: "+head);
	}
	@Override
	public String toString() {
		return "MapNode{ " + head + '}';
	}
}
