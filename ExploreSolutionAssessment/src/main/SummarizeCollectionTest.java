package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SummarizeCollectionTest {

	@Test
	void test() {
		String values = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		NumberRangeImp main = new NumberRangeImp(values);
		
		String result = main.summarizeCollection(main.collect(values));
		assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
		
	}

}
