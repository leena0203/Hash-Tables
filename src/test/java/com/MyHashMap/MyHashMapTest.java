package com.MyHashMap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyHashMapTest {
	/**
	 * UC1 test to return word frequency in hashMap. 
	 */
	@Test
	public void givenASentence_whenWordsAreAddedToList_ReturnWordFrequency() {
		String sentence = "To be or not to be";
		MyHashMap<String, Integer> test = new MyHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for(String word :words) {
			Integer value = test.get(word);
			if (value == null) {
				value =1;
			}
			else {
				value = value +1;
			}
			test.add(word, value);
		}
		int frequency = test.get("to");
		System.out.println(test);
		System.out.println(frequency);
		assertEquals(2, frequency);
	}
}
