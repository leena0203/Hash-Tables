package com.MyHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyLinkedHashMapTest {

	@Test
	public void givenASentence_WhenWordsAreAddedToList_ShouldReturnParanoidFrequency() {
		String sentence = "Paranoids are not paranoid because they are paranoid "
				+ "but because they keep putting themselves " + "deliberately into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> test = new MyLinkedHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = test.get(word);
			if (value == null) {
				value = 1;
			} else {
				value = value + 1;
			}
			test.add(word, value);
		}
		int frequency = test.get("paranoid");
		System.out.println(test);
		test.remove("avoidable"); 							//Removing the "avoidable" node from the list
		System.out.println(test);
		assertEquals(3, frequency);
	}

}


