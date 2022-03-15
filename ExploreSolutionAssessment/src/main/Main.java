package main;

import java.util.Collection;

/*   
 *	 @Authur:	Makgabo Emmanuel Mathekga
 *   Date:      2022/03/11 
 *   Task:      Coding Asssesment  
 * 
 * */

public class Main {

	public static void main(String[] args) {
	
		String values = "1,3,6,7,8,12,13,14,15,21,22,23,24,31"; 
		
		NumberRangeImp range = new NumberRangeImp( values );
		
		Collection<Integer> thisint = range.collect(values);
		
		System.out.println("Result: " + range.summarizeCollection( thisint  )); 
		
	}

}

