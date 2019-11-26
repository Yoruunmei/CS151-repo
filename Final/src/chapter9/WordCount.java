package chapter9;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class WordCount {

	public static Callable<Integer> countWordsWithLength(String filePath) {
		return () -> {
			int numOfWordsGT4 = 0;	
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
//				BufferedReader br = new BufferedReader(new FileReader(listOfFiles.get(0))); // get first file
				String line;
				
				while ((line = br.readLine()) != null) {	// Continuously read next line.
					String [] wordsInLine = line.split(" "); // Separate line into individual words.
					
					for (int i = 0; i < wordsInLine.length; i++) {
						if (wordsInLine[i].length() >= 4) {	// Check length of each word. 
							numOfWordsGT4++;
						} else {
							// do nothing.
						}
					}
				}
				//System.out.println(listOfFiles.get(0).getName() + " : " + numOfWordsGT4);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return numOfWordsGT4;
		};
	}
	
	
	// java -classpath . chapter9.WordCount /Users/victorshih/Documents/SJSU/Yr\ 3\ -\ Semester\ 1/CS151/Exam/Shih_Victor_final/Test\ Files/File1.txt
	public static void main(String[] args) {
//		int numOfFiles = args.length;
//		ArrayList<File> listOfFiles = new ArrayList<File>();
//		for (int i = 0; i < numOfFiles; i++) {
//			listOfFiles.add(new File(args[i]));
//		}
//		ExecutorService service = Executors.newFixedThreadPool(numOfFiles);		
		ExecutorService service = Executors.newFixedThreadPool(1);
		
		// Make array of numOfFiles Runnable instances.
		// Execute each Runnable instance.	
		
		// counts the words with their length are greater than or equal 4
		/** read a word. 
		 * if word length is >= 4 : increase count by 1.
		 * else : do nothing
		 * read next word.
		 */	
		// split by spaces: String input = "Hello I'm your String";
		String nonTerminalTestFile = "/Users/victorshih/Documents/SJSU/Yr 3 - Semester 1/CS151/CS151-repo/Final/src/chapter9/NonTerminalTest";
		ArrayList<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
		tasks.add(countWordsWithLength(nonTerminalTestFile));
		
		try {
			ArrayList<Future<Integer>> results = (ArrayList<Future<Integer>>) service.invokeAll(tasks);
			for (Future<Integer> result : results) {
				System.out.println("NonTerminalTest : " + result.get().toString());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace(); // error in result.get()
		}	
		
		
		service.shutdown();
	}
}
