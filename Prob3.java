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
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			ArrayList<String> wordList = new ArrayList<String>();
			while(scan.hasNextLine()){
				String[] words = scan.nextLine().split(" ");
				for(int i = 0; i < words.length; i++){
					if(map.containsKey(words[i])){
						map.put(words[i],map.get(words[i])+1);
					}else{
						wordList.add(words[i]);
						map.put(words[i],1);
					}
				}
			}
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