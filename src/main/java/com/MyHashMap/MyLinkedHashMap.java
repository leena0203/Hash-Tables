package com.MyHashMap;
import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
	private final int numOfBuckets;
	ArrayList<MyLinkedList> bucketArray;

	public MyLinkedHashMap() {
		this.numOfBuckets = 10;
		this.bucketArray = new ArrayList(numOfBuckets);
		for (int i = 0; i < numOfBuckets; i++) {
			this.bucketArray.add(null);
		}
	}

	/**
	 * Returning the value for respective key
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> list = this.bucketArray.get(index);
		if (list == null) {
			return null;
		}
		MyMapNode<K, V> myMapNode = (MyMapNode) list.search(key);
		V value;
		if (myMapNode == null) {
			value = null;
		} else {
			value = myMapNode.getValue();
		}
		return value;
	}

	/**
	 * Adding the list to index or updating the node in the list
	 * 
	 * @param key
	 * @param value
	 */
	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> list = this.bucketArray.get(index);
		if (list == null) {
			list = new MyLinkedList<>();
			this.bucketArray.set(index, list);
		}
		MyMapNode<K, V> myNode = (MyMapNode) list.search(key);
		if (myNode == null) {
			myNode = new MyMapNode<>(key, value);
			list.append(myNode);
		} else {
			myNode.setValue(value);
		}
	}

	/**
	 * finding the hash code for the key and returning array index
	 * 
	 * @param key
	 * @return
	 */
	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numOfBuckets;
		return index;
	}

	public String toString() {
		return "MyLinkedHashMap List{" + bucketArray + "}";
	}

	public void remove(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> list = this.bucketArray.get(index);
		if (list == null) {
			System.out.println("The key does not exist");
			return;
		}
		MyMapNode<K, V> myMapNode = (MyMapNode) list.search(key);
		list.delete(myMapNode);
	}
}