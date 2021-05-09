package array;

/**
 * Input:   str1 = "geek", str2 = "gesek"
 * Output:  1
 * We can convert str1 into str2 by inserting a 's'.
 *
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1
 * We can convert str1 into str2 by replacing 'a' with 'u'.
 *
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 *
 */
public class EditDistance {
    public static void main(String[] args) {

        String s1 = "sunday";
        String s2 = "saturday";
        int [][] result = getResult(s1,s2);
        System.out.println("Minimum distance is "+result[s1.length()][s2.length()]);

    }

    private static int[][] getResult(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] result = new int[m+1][n+1];
        for(int i =0; i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i ==0){
                    result[i][j] = j;
                }else if(j==0){
                    result[i][j] = result[i-1][j]+1;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    result[i][j] = result[i-1][j-1];
                } else{
                    result[i][j] = min(result[i-1][j-1], result[i-1][j], result[i][j-1]) +1;
                }

            }
        }
        return result;
    }

    private static int min(int a, int b, int c) {
        return a < b ? (a <c ? a :c) : (b<c ? b:c);
    }


}
