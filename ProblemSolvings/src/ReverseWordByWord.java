/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class ReverseWordByWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "This is morgan stanley interview question";
		String[] strArr = str.split(" ");
		String str2 = "";
		for(int i=strArr.length-1;i>0;i--){
			str2 += strArr[i]+" ";
		}
		System.out.println(str2);
		

	}

}
