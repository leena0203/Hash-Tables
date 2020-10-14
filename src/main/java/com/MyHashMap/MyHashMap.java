package com.MyHashMap;

public class MyHashMap<K, V> {
	MyLinkedList<K> myLinkedList;

	/**
	 * Constructor
	 */
	public MyHashMap() {
		myLinkedList = new MyLinkedList<>();
	}

	/**
	 * Return the value of key
	 * @param key
	 * @return
	 */
	public V get(K key) {
		MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) this.myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue() ;
	}
	/**
	 * add new valid key
	 * @param key
	 * @param value
	 */
	public void add(K key, V value) {
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.search(key);
		if((myMapNode == null)) {
			myMapNode = new MyMapNode<>(key, value);
			this.myLinkedList.append(myMapNode);
		}else {
			myMapNode.setValue(value);
		}
	}
	
	/**
	 * Return the result
	 */
	public String toString() {
		return "MapNode{ " + myLinkedList + '}';
		
	}

}
