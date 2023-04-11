package com.orcl.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class FileUtil {

	/**
	 *
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String[] readLineByLine(String filename) throws IOException{
		
		File file = new File(filename);
		String[] strArr = new String[10];
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line ="";
		int i=0;
		while((line = bufferedReader.readLine())!= null){
			strArr[i]= line;
			i++;
		}
		return strArr;
	}
	public static void main(String[] args) throws IOException{
		//readLineByLine("C:/MyWorkspace/Algorithm/git/ProblemSolvings/src/test.txt");
		String[] arr = readLineByLine("test.txt");
		System.out.println(arr);
		writeLineByLine(arr,"test2.txt");
	}
	public static void writeLineByLine( String[] strArr,String filename) throws IOException{
		File file = new File(filename);
		FileWriter writer = new FileWriter(file);
		BufferedWriter buf = new BufferedWriter(writer);
		for(int i=0;i<strArr.length;i++){
			if(strArr[i] != null){
				buf.write(strArr[i]);
				buf.newLine();
			}
			
		}
		buf.close();
	}

}
