package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SummarizeCollectionsTestStrings {

	@Test
	void test() {
		String values = "4,yryter, 5,3, 1 ,2";
		NumberRangeImp main = new NumberRangeImp(values);
		
		String result = main.summarizeCollection(main.collect(values));
		assertEquals("1-5", result);
		
	}


}
