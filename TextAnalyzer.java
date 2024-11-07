// CST 1201 – PROJECT due on 5/17/24 
// Savara Khan 

import java.io.*;
import java.util.*;

public class TextAnalyzer {

	public static void main(String[] args) throws IOException  //(main)


	{
		//Declarations 
		
		String filename, theText;
		int numChar;
		
		// ( 1st task) ask the user for the filename
		
		filename = getFilename ();
		
		// (2nd task) read the file
		
		theText = getText(filename);
		
		// (3rd task) Calculate the number of characters in the file
		numChar = calcNumChar(theText);
		System.out.print("\n" + "The number of characters is = " + numChar);
		
		analyzeWordLengths(theText); // question 4 
		
		analyzeSingleUniGrams(theText); // question 5
		
		analyzePairBiGrams(theText); // question 6 
		
		System.out.println("\n--Thank you, Professor, for your guidance and support! It was a wonderful semester :) --");
		
		
		
		

	}
	public static void analyzechar(String text) // (task 4)

	{ 
		text = text.toLowerCase();
		char[] characters = new char [ 26];
		int[] rep = new int[26];
		
		char ch ='a';
		for ( int i =0; i< characters.length; i++) 
		{
			characters[i] = ch;
			ch++;
		}
		//System.out.println(Arrays.toString(characters));
		
		for (int i= 0; i<text.length(); i++) 
		{
			ch = text.charAt(i);
			if (ch >= 'a' && ch <= 'z') 
			{
				int index =ch -'a';
				rep[index]++;
				
			}
		}
	
		for (int i= 0; i< characters.length; i++) {
			System.out.println(characters[i]  + " repeats " + rep[i] + " times.");	
		}
	}
	public static int calcNumChar(String text) throws IOException // (task 3)
	
	{
		return text.length();
	}
	
 	public static String getText(String  filename) throws IOException // (task 2)
	
	{
		//declarations
		String line = "", allText = "";
		
		// open the file 
		File myFile = new File(filename);
		Scanner inputFile = new Scanner(myFile);
		
		// read the file 
		while(inputFile.hasNext())
		{
			line = inputFile.nextLine();
			System.out.println(line); //for debugging
			allText = allText + " " + line;
		}
		
		//close the file 
		
		inputFile.close();
		return allText;
	}
	
	
	public static String getFilename() throws IOException // (task 1)
	{
		String file;
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the name of the file: ");
		file = kb.nextLine();
		return file;
		
	}
	public static int countWords(String text) // 3)Number of words in the text.
	{
        String[] words = text.split("\\s+");
        return words.length;
    }
	
	public static void analyzeWordLengths(String text)  // 4)The sizes of the longest and the shortest word.
	{
        String[] words = text.split("\\s+");
        int shortestLength = Integer.MAX_VALUE;
        int longestLength = 0;

        for (String word : words) {
            int length = word.length();
            if (length < shortestLength) {
                shortestLength = length;
            }
            if (length > longestLength) {
                longestLength = length;
            }
        }

        System.out.println( "\n" + "The shortest word has " + shortestLength + " characters.");
        System.out.println("The longest word has " + longestLength + " characters.");
    }
	
	public static void analyzeSingleUniGrams(String text) // 5)The twenty most repeated uni-grams (single words) in the text in descending order.
	{
	    HashMap<String, Integer> wordFreq = new HashMap<>();
	    String[] words = text.split("\\s+");

	    for (String word : words) {
	        wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
	    }
	    // Sort the uniGrams in descending order
	    ArrayList<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordFreq.entrySet());
	    sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));
	   // Print the top 20 most repeated uniGrams
	    System.out.println("\n" + "Twenty most repeated Single uniGrams:");

	    for (int i = 0; i < Math.min(20, sortedWords.size()); i++) {
	        System.out.println(sortedWords.get(i).getKey() + " - " + sortedWords.get(i).getValue() + " times");
	    }
	}
	
	public static void analyzePairBiGrams(String text) // 6)The twenty most repeated bi-grams (pairs of words) in the text in descending order.
	{
        HashMap<String, Integer> biGramFreq = new HashMap<>();
        String[] words = text.split("\\s+");

        for (int i = 0; i < words.length - 1; i++) {
            String biGram = words[i] + " " + words[i + 1];
            biGramFreq.put(biGram, biGramFreq.getOrDefault(biGram, 0) + 1);
        }
        // Sort the biGrams in descending order
        ArrayList<Map.Entry<String, Integer>> sortedBiGrams = new ArrayList<>(biGramFreq.entrySet());
        sortedBiGrams.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        // Print the top 20 most repeated biGrams
        System.out.println("\n" + "Twenty most repeated pair of biGrams:");
        
        for (int i = 0; i < Math.min(20, sortedBiGrams.size()); i++) {
            System.out.println(sortedBiGrams.get(i).getKey() + " - " + sortedBiGrams.get(i).getValue() + " times");
            
        }
    }

}


