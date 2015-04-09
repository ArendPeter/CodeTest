import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Prob3{
	public static void main(String[] args){
		String fileName = "test.txt";
		try{
			Scanner scan = new Scanner(new FileInputStream(fileName));
			//keeps track of words as well as counts. 
			//HashMap is used for fast lookup times
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			//list keeps track of all words we've currently found
			//ArrayList is used so we can easily iterate through all words
			ArrayList<String> wordList = new ArrayList<String>();
			//loop through lines of file
			while(scan.hasNextLine()){
				String[] words = scan.nextLine().split(" ");
				//loop through words in line
				for(int i = 0; i < words.length; i++){
					//case where we're adding a word which we've already processed
					if(map.containsKey(words[i])){
						map.put(words[i],map.get(words[i])+1);
					//case where we've found a new word. Initalize the count to 1
					}else{
						wordList.add(words[i]);
						map.put(words[i],1);
					}
				}
			}
			//loop through all words and print their associated value
			for(int i = 0; i < wordList.size(); i++){
				String curWord = wordList.get(i);
				System.out.println( map.get(curWord) + " " + curWord);
			}
			scan.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}