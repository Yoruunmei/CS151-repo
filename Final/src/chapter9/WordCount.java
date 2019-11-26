package chapter9;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class WordCount {

	
	public static Callable<Integer> countWordsWithLengthAtMost4(File file) {
		return () -> {
			int numOfWordsGT4 = 0;	
			try {
				BufferedReader br = new BufferedReader(new FileReader(file)); // get first file
				String line;
				
				while ((line = br.readLine()) != null) {	// Continuously read next line.
					
					String [] wordsInLine = line.trim().replaceAll(" +", " ").split(" "); // Separate line into individual words.
					
					for (int i = 0; i < wordsInLine.length; i++) {
						if (wordsInLine[i].length() <= 4 && wordsInLine[i].trim().length() != 0) {	// Check length of each word. 
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
	
	
	/**
	 * Counts number of words with length >= 4 within a file. 
	 * @param file the file to be analyzed. 
	 * @return the instance of a Callable<Integer> that returns the value of the number of words with length >= 4.
	 */
	public static Callable<Integer> countWordsWithLengthAtLeast4(File file) {
		return () -> {
			int numOfWordsGT4 = 0;	
			try {
				BufferedReader br = new BufferedReader(new FileReader(file)); // get first file
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
	/** Everytime a change is saved, need to :
	 * <go to dir with .java file>
	 * <compile java file>
	 * 	javac WordCount.java
	 * 	cd ..
	 * 	java -classpath . chapter9.WordCount <args here with spaces betw>
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		// TERMINAL INPUT
		int numOfFiles = args.length;
		ArrayList<File> listOfFiles = new ArrayList<File>();
		for (int i = 0; i < numOfFiles; i++) {
			listOfFiles.add(new File(args[i]));
		}
		ExecutorService service = Executors.newFixedThreadPool(numOfFiles);		
		
		// NON TERMINAL INPUT (for debugging).
//		ExecutorService service = Executors.newFixedThreadPool(2);
//		
//		ArrayList<File> listOfFiles = new ArrayList<File>();
//		int numOfFiles = 2;
//		listOfFiles.add(new File("/Users/victorshih/Documents/SJSU/Yr 3 - Semester 1/CS151/CS151-repo/Final/src/chapter9/File1.txt"));
//		listOfFiles.add(new File("/Users/victorshih/Documents/SJSU/Yr 3 - Semester 1/CS151/CS151-repo/Final/src/chapter9/File2.txt"));
		// end block here for non terminal input.
		System.out.println("# of words with at least length 4 in each file:");
		// For >=4 method
		ArrayList<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();

		for (int i = 0; i < listOfFiles.size(); i++) {
			tasks.add(countWordsWithLengthAtLeast4(listOfFiles.get(i)));
		}
		if (tasks.size() != numOfFiles)
			System.out.println("# of callables doesn't match # of files");
		
		try {
			ArrayList<Future<Integer>> results = (ArrayList<Future<Integer>>) service.invokeAll(tasks);
			int i = 0;
			for (Future<Integer> result : results) {
				System.out.println(listOfFiles.get(i).getName() + " : " + result.get().toString());
				i++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace(); // error in result.get()
		}	
		
		// For <=4 method
		ArrayList<Callable<Integer>> tasks2 = new ArrayList<Callable<Integer>>();
		System.out.println("# of words with at most length 4 in each file:");
		for (int i = 0; i < listOfFiles.size(); i++) {
			tasks2.add(countWordsWithLengthAtMost4(listOfFiles.get(i)));
		}
		if (tasks2.size() != numOfFiles)
			System.out.println("# of callables doesn't match # of files");
		
		try {
			ArrayList<Future<Integer>> results = (ArrayList<Future<Integer>>) service.invokeAll(tasks2);
			int i = 0;
			for (Future<Integer> result : results) {
				System.out.println(listOfFiles.get(i).getName() + " : " + result.get().toString());
				i++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace(); // error in result.get()
		}	
		service.shutdown();
	}
}
