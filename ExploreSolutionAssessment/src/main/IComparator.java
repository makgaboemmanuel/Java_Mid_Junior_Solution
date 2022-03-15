package main;

import java.util.Comparator;

class IComparator implements Comparator<Integer> {
	
	@Override
	public int compare(Integer arg0, Integer arg1) {
		if( arg1 > arg0 ) {
			return -1;
		}
		else {
			return 1;
		}
		
	}
}
