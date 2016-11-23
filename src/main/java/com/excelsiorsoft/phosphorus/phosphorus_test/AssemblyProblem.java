package com.excelsiorsoft.phosphorus.phosphorus_test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Encapsulates main logic of the Assembly Problem excercise
 * 
 * @author Simeon
 *
 */
public class AssemblyProblem {
	
	private  List<List<String>> outcasts = new ArrayList<>(); 
	private long counter;
	
	public long getCounter() {
		return counter;
	}

	public  List<List<String>> getOutcasts() {
		return outcasts;
	}

	/**
	 * Encapsulates finding the longest overlap between two strings logic for Part A of the excercise
	 * 
	 * @param first string to compare
	 * @param second string to compare
	 * @param verbose if `yes`, returs a full breakdown of found longest overlap
	 * @return
	 */
	public /*static*/ int longestSubstr(String first, String second, boolean verbose) {     
	    int maxLen = 0;
	    int fl = first.length();
	    int sl = second.length();
	    int[][] table = new int[fl+1][sl+1];
	    int[] result = new int[3];
	 
	    for (int i = 1; i <= fl; i++) {
	        
	    	for (int j = 1; j <= sl; j++) {
	            
	        	if (first.charAt(i-1) == second.charAt(j-1)) {
	                    
	            		table[i][j] = table[i - 1][j - 1] + 1;
		                
	                    if (table[i][j] > maxLen){
		                
		                    maxLen = table[i][j];
		                    result[0] = maxLen;
		                    result[1] = i;
		                    result[2] = j;
		                }
	            }
	        }
	    }
	    
	    if(verbose){
	    	
	    	System.out.println("longestOverlapLength="+result[0]+"; posInFirst="+result[1]+"; posInSecond="+result[2]);
	    	System.out.println("overlapingSegment in first="+first.substring(result[1]-result[0], result[1]));
	    	System.out.println("overlapingSegment in second="+second.substring(result[2]-result[0], result[2]));
	    }
	    return maxLen;
	}
	
	/**
	 * Encapsulates finding combinations logic for Part B of the excercise
	 * 
	 * @param soughtOverlap
	 * @param sequences
	 * @throws IOException
	 */
	public   void combinations(int soughtOverlap, Map<String, String> sequences) throws IOException{
		

		
		
		long counter = 0;
		List<List<String>> outcasts = new ArrayList<>();
		
		for (int i = 0; i < sequences.size(); i++) {
			  for (int j = i+1; j < sequences.size(); j++, counter++) {
			    	 
				  	System.out.println(soughtOverlap+"|"+counter+" => "+i+":"+j);
				  
			    	 int overlap = longestSubstr(sequences.get("sequence_"+i),sequences.get("sequence_"+j), false);
			    	 if(overlap == soughtOverlap){
			    		
			    		 List<String> is = new ArrayList<>();
			    		 is.add("sequence_"+i);
			    		 is.add(sequences.get("sequence_"+i));
			    		 outcasts.add(is);
			    		 
			    		 List<String> js = new ArrayList<>();
			    		 js.add("sequence_"+j);
			    		 js.add(sequences.get("sequence_"+j));
			    		 outcasts.add(js);

			    	 }
			    	 
			    	 

			  }
			}
		
		this.counter = counter;
		this.outcasts = outcasts;
		

		
	}
}
