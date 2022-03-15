package main;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// import java.util.Collections;
// import java.util.PriorityQueue;

public class NumberRangeImp implements NumberRangeSummarizer {
	
	private String iinput; 
	
	NumberRangeImp(String aninput){
		 this.iinput = aninput;
	}
	
	public boolean checkPositive(String cstring) {
		/* to check for positive numbers */
		String regexs = "\\d+"; 
		Pattern pats = Pattern.compile(regexs);
		Matcher mats = pats.matcher(cstring);
		boolean boochecks = mats.matches();
		
		return boochecks;
	}
	
	public boolean checkNegative(String cstring) {
		/* this is to check for positive numbers */
		String regex = "\\-\\d+"; 
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(cstring);
		boolean boocheck = mat.matches();
		
		return boocheck;
	}
	
	/* this is to create the final string to be returned */
	public String createLine(String [] my_data) {
		String tosend = "";
		for(String hu: my_data) {
			 if( tosend.isEmpty() ) {
				 tosend  = hu;
			 }else {
				 tosend  = tosend  + ", " + hu;
			 }
		}  
		return tosend;
	}
	
	@Override
    public Collection<Integer> collect(String input) {
		// input = this.iinput;
    	List<Integer> my_ints = new ArrayList<Integer>();
    	
    	String [] data = input.replaceAll(" ", "").split(","); /* this is replace all leading and trailing spaces */

		for(String s: data) {
			/* this is to check for negative numbers */
			boolean boocheck = checkNegative(s);
			
			/* to check for positive numbers */
			boolean boochecks = checkPositive(s);
			
			if( boocheck || boochecks ) { /* this is to make sure that only Integer Data Type values are added to the List */
				my_ints.add( Integer.valueOf(s) );
			}
    		
    	}    	
    	
    	Collections.sort(my_ints, new IComparator()); /* use the comparator class to sort the list */
		return my_ints;
	}
    
	@Override
    public String summarizeCollection(Collection<Integer> input) {
		input = collect( iinput ); 

    	StringBuilder line = new StringBuilder(); 
    	int [] nums = new int[ input.size()  + 1] ; /* the extra elements is added so that it can be a delimiter */
    	int i = 0;
    	for(Integer n : input) {
    		nums[i] = n;
    		i++;
    	} 
    	
    	nums[ input.size()] = 0; /* this is the delimiter that will have to be ignored and makes sure that the last element is accounted */
    	 
    	int right  = 0;
    	
    	for(int a = 0; a < nums.length - 1 ; a++) {
    		
    		if( nums[a + 1] - nums[a] == 1) {
    			int left = nums[a];
    			right    = nums[a+1];
    			if( line.indexOf( String.valueOf( right  )) > 0 ) {
    				 line.append( left + "-" + right ); 
    			} 
    			line.append( left + "-" + right  + ".");     			
    		}
    		else {
    			line.append(nums[a] + ",");
    		}
    	}
    	
    String [] coms = line.toString().split(",") ;
	int f = 0 ;
	for(String p: coms) {
			int first = -1; 
			int acount = 0; 
			for(String st: p.split("")) {
				if(first == -1 && st.equalsIgnoreCase("-")) {					
					first = acount; 
				}			
				acount++; 
			}
			if( p.indexOf(".") > 0){
				coms[f] = p.substring( 0, first )  + "-" + p.substring(p.lastIndexOf(".") + 1, p.length()  ) ;		 	
			}
			f++;			
	}
	
		String tosend = createLine(coms);
		/* for(String hu: coms) {
			 if( tosend.isEmpty() ) {
				 tosend  = hu;
			 }else {
				 tosend  = tosend  + ", " + hu;
			 }
		}   */
		return tosend; 
	}

}
