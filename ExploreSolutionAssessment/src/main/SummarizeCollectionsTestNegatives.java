package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SummarizeCollectionsTestNegatives {

	@Test
	void test() {
		String values = "0, Mathekga,-8, 3,Makgabo Emmanuel, 4";
		NumberRangeImp main = new NumberRangeImp(values);
		
		String result = main.summarizeCollection(main.collect(values));
		assertEquals("-8, 0, 3-4", result);
	}

}
