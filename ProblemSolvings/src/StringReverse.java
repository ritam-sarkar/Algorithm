

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String input = "Qrtuyu Ohghgjg";
       String output="";
       char[] chs = input.toCharArray();
       for(int i=chs.length-1;i>=0;i--){
    	   if(i==chs.length-1 || chs[i+1]==' '){
    		   output += Character.toUpperCase(chs[i]);
    	   }else if(i==0 || chs[i-1]==' '){
    		   output += Character.toLowerCase(chs[i]);
    	   }else{
    		   output += chs[i];
    	   }
       }
       System.out.println(output);
	}

}
