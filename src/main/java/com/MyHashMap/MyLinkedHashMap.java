package com.MyHashMap;
import java.util.ArrayList;

public class MyLinkedHashMap<k, v> {
	private final int numBuckets;
	ArrayList<MyLinkedList<k>> myBucketArray;

	public MyLinkedHashMap() {
		numBuckets = 10;
		myBucketArray = new ArrayList<>(numBuckets);
		// creating empty array list
		for (int i = 0; i < numBuckets; i++)
			myBucketArray.add(null);
	}

	/**
	 * Returns the value for given key
	 * 
	 */
	@SuppressWarnings("unchecked")
	public v get(k key) {
		int index = getBucketIndex(key);
		MyLinkedList<k> myLinkedList = myBucketArray.get(index);
		if (myLinkedList == null)
			return null;
		MyMapNode<k, v> myHashNode = (MyMapNode<k, v>) myLinkedList.search(key);
		return (myHashNode == null) ? null : myHashNode.getValue();
	}

	/**
	 * Adding the list to index or updating the node in the list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void add(k key, v value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<k> myLinkedList = myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			myBucketArray.set(index, myLinkedList);
		}
		MyMapNode<k, v> node = (MyMapNode<k, v>) myLinkedList.search(key);
		if (node == null) {
			node = new MyMapNode<>(key, value);
			myLinkedList.append(node);
		} else {
			node.setValue(value);
		}
	}

	/**
	 * finds the hash code for the key and returns array index
	 * 
	 */
	private int getBucketIndex(k key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numBuckets;
		return index;
	}

	@Override
	public String toString() {
		return "MyLinkedHashMap List{" + myBucketArray + "}";
	}

}

