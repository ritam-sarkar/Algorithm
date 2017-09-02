import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Input : {"aaa", "bbb", "ccc", "bbb", 
         "aaa", "aaa"}
Output : bbb

Input : {"geeks", "for", "geeks", "for", 
          "geeks", "aaa"}
Output : for
 */

/**
 * @author Ritam
 *
 */
public class FindNoOfOccurranceOfWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      String words[] = getWordArrayFromSentence("aaa of ccc ccc ddd the bbb ccc aaa ddd in is aaa"); 
      WordOccuranceCalculator woc = new WordOccuranceCalculator(words);
      woc.calculateMax();
      System.out.println("second max occurance "+woc.secondmax());
      System.out.println(" max occurance "+woc.getmax());
      woc.calculateMin();
      System.out.println(" min occurance "+woc.getMin());
      System.out.println(" second min occurance "+woc.secondmin());
	}
	
	private static String[] getWordArrayFromSentence(String sentence){
		String words[] = sentence.split("\\s+");
		for(int i=0;i<words.length;i++){
			words[i] = words[i].replaceAll("[^\\w]", "");
		}
		return words;
	}	

}
class WordOccuranceCalculator{
	
	private int max,secondmax =0;
	private int min=1,secondmin = 2;
	Map<String,Integer> wordMap;
	public String getMin() {
		return getKeyByValue(min);
	}
	public String secondmin() {
		return getKeyByValue(secondmin);
	}
	private String[] words;
	
	public WordOccuranceCalculator(String[] words) {
		super();
		this.words = words;
		
	}
	
	
	public void calculateMax(){		
		buildMap();
		for(Map.Entry<String, Integer> entry : wordMap.entrySet()){
		  if(entry.getValue()>max){
			  secondmax = max;
			  max = entry.getValue();
		  }else if(entry.getValue() > secondmax && entry.getValue()!=max){
			  secondmax = entry.getValue();
		  }
		}		
	}
	public void calculateMin(){			
		buildMap();
		
		for(Map.Entry<String, Integer> entry : wordMap.entrySet()){
		  if(entry.getValue()<min){
			  secondmin = min;
			  min = entry.getValue();			  
		  }else if(entry.getValue() != min && entry.getValue()< secondmin){
			  secondmin = entry.getValue();
		  }
		}		
	}
	private void buildMap(){
		wordMap = new HashMap<String,Integer>(words.length+1);
		for(int i=0;i<words.length;i++){
			if(wordMap.containsKey(words[i])){
				wordMap.put(words[i], wordMap.get(words[i])+1);
			}else{
				wordMap.put(words[i],1);
			}
		}
	}
	public String getmax(){		
		return getKeyByValue(max);
	}
	public String secondmax(){		
		return getKeyByValue(secondmax);
	}
	private String getKeyByValue(int value){
		Set<String> keySet = wordMap.keySet();
		for(String key : keySet){
			if(wordMap.get(key) == value){
				return key;
			}
		}
		return null;
	}
}

