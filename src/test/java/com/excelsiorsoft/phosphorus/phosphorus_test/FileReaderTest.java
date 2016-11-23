package com.excelsiorsoft.phosphorus.phosphorus_test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

public class FileReaderTest extends TestCase {

	FileReader cut = new FileReader();
	
	@Test
	public void testIngestion() throws IOException {
		//Map<String, String> sequences = cut.injest("lambda_virus.txt");
		Map<String, String> sequences = cut.injest("small-file.txt");
		//Map<String, String> sequences = cut.injest("small-file-3.txt");
		//Assert.assertTrue("wrong size: expect 1650 sequences", sequences.size() == 1650);
		
		//long start = System.currentTimeMillis();
		
		for(Map.Entry<String, String> entry1: sequences.entrySet()) {
			String key1 = entry1.getKey();
			   int hash1 = System.identityHashCode(key1);
			   String value1 = entry1.getValue();
			   for(Map.Entry<String, String> entry2: sequences.entrySet()) {
				   String key2 = entry2.getKey();
			       if (hash1 > System.identityHashCode(key2)) continue;

			       String value2 = entry1.getValue();
			       // compare value1 and value2;
			       System.out.println(key1+":"+key2);
			      
			   }
			}
		
		/*List<String> seqs = new ArrayList<String>(sequences.values());
		long counter = 0;
		for (int i = 0; i < seqs.size(); i++) {
			  for (int j = i+1; j<seqs.size(); j++) {
			    //if (!seqs.get(i).equals(seqs.get(j))) {
			    	 System.out.println(counter+" => "+i+":"+j);
			    	 counter++;
			    //}
			  }
			}
		
		long end = System.currentTimeMillis();
		System.out.println("elapsed mins: " + (end - start)/(60*1000F));*/
	}
	
	
	
}
