package com.orcl.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]


 * @author ritsarka
 *
 */
public class DnaSequenceProblem {

	public static void main(String[] args) {

		 String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		 Map<String,Integer> map = new HashMap<>();
	        List<String> res = new ArrayList<>();
	        for(int i=0;i+10<=s.length();i++){
	            String str = s.substring(i,i+10);
	            map.put(str,map.getOrDefault(str,0)+1);
	            if(map.get(str)==2) res.add(str);
	        }
	     System.out.println(res);  
	}

}
