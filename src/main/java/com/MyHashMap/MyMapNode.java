package com.MyHashMap;

public class MyMapNode<K, V> implements INode<K> {
	K key;
	V value;
	MyMapNode<K, V>next;
	
	public MyMapNode(K key,V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public INode getNext() {
		return next;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setNext(@SuppressWarnings("rawtypes") INode next) {
		this.next = (MyMapNode<K, V>) next;
	}
	
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	 
	public String toString() {
		StringBuilder nodeString = new StringBuilder();
		nodeString.append("MapNode{ " + "K=").append(key)
		.append(", V= ").append(value).append('}');
		if(next != null)
			nodeString.append("->").append(next);
		return nodeString.toString();
	}
	

}
