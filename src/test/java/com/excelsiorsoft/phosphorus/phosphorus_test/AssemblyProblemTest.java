package com.excelsiorsoft.phosphorus.phosphorus_test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;


public class AssemblyProblemTest extends TestCase {
	
	AssemblyProblem cut = new AssemblyProblem();
	
	@Test
	public void testLongestSubstr() {
		/*
		int result  = longestSubstr("TGAGTGGA", 
									"AAGGTGAG");
		*/
		/*int result  = longestSubstr("AAGGTGAG", 
				"TGAGTGGA");*/
		/*System.out.println(result);*/
		
/*		System.out.println(longestSubstr("TGCATAACGGTTTCGGGATTTTTTATATCTGCACAACAGGTAAGAGCATTGAGTCGATAATCGTGAAGAGTCGGCGAGCCTGGTTAGCCAGTGCTCTTTC", 
					  "GTGTATGCAGTATTTTCGACAATGCGCTCGGCTTCATCCTTGTCATAGATACCAGCAAATCCGAAGGCCAGACGGGCACACTGAATCATGGCTTTATGAC"));*/
		
		String first = "AAGCGGCGGCAATACGTGCAAAAAATTCGGCAAAACGTGCAGAAGATATAGCTTCAGCTGTCGCGCTTGAGGATGCGGACACAACGAGAAAGGGGATAGT";
		String second = "GGTCCTTTCCGGTGATCCGACAGGTTACG";
		
		System.out.println("Longest Overlap between "+ first +" and " + second + " is: "+ +cut.longestSubstr(first,second , true));
		
		
	}
	
	@Test
	public void testCulprit() {

		
		String first = "AGGATTTTGGAACCTCTTGCAGTACTACTGGGGAATGAGTTGCAATTATTGCTACACCATTGCGTGCATCGAGTAAGTCGCTTAATGTTCGTAAAAAAGC";
		String second = "GGTCCTTTCCGGTGATCCGACAGGTTACG";
		
		System.out.println("Longest Overlap between "+ first +" and " + second + " is: "+ +cut.longestSubstr(first,second , true));
		
		
	}
	
	
	@Test
	public void testCombinationBuilding() throws IOException {
		
		long expctdTrials = 1650 * 1649 / 2;
		
		FileReader fileReader = new FileReader();
		//Map<String, String> sequences = fileReader.injest("small-file.txt");
		//Map<String, String> sequences = fileReader.injest("small-file-error.txt");
		Map<String, String> sequences = fileReader.injest("lambda_virus.txt");
		
		List<List<String>> outcasts = null;
		for (int i = 1; i < 10; i++) {
			//int i = 3;
			cut.combinations(i, sequences);
			Assert.assertEquals("wrong # of trials, expecting  ", expctdTrials, cut.getCounter());
			
			outcasts = cut.getOutcasts();
			int outcastSz = outcasts.size();
			System.out.println("outcasts=" + outcasts);
			System.out.println("outcasts.size=" + outcastSz);
			if(outcastSz > 0) break;
		}
		
		cut.longestSubstr(outcasts.get(0).get(1),outcasts.get(1).get(1) , true);
	}
	

}
