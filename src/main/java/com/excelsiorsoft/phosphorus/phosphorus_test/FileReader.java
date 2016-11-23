package com.excelsiorsoft.phosphorus.phosphorus_test;

import static java.util.regex.Pattern.compile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
	
	private static final String SEQ_STARTER = ">";
	private static final String LINE_SEPARATOR = "\n";

	public Map<String, String> injest(String fileName) throws IOException{
		
		/*ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());*/
		
		/*Stream<String> lines = Files.lines(new File(getClass().getClassLoader().getResource(fileName).getFile()).toPath());
*/
		
		Map<String, String> sequences = new HashMap<>();
		Scanner fileScanner = new Scanner(new File(getClass().getClassLoader().getResource(fileName).getFile()));
		Scanner seqScanner  = null;
		try{
		
		fileScanner.useDelimiter(compile(SEQ_STARTER));
		
		while(fileScanner.hasNext()){
			
			String fullSequence = fileScanner.next();
			
			seqScanner = new Scanner(fullSequence);
			//seqScanner.useDelimiter((String)System.getProperty("line.separator"));  
			seqScanner.useDelimiter(LINE_SEPARATOR); 			//would use above line if files were coming from both Windows & Unix
			
			while(seqScanner.hasNext()){
				String seqNumber = seqScanner.next().trim();
				String seqBody = seqScanner.next().trim();
				sequences.put(seqNumber, seqBody);
			}
			
		}
		
		}finally{
			
			fileScanner.close();
			seqScanner.close();
		}
		
		return sequences;

	}
	
	
	

}
