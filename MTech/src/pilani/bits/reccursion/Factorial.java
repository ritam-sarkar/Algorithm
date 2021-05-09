package pilani.bits.reccursion;

public class Factorial {
   public static void main(String[] args) {
      int n = 4;
      System.out.println("Factorial of "+n +" is "+fact(n));
   }

   private static int fact(int n) {

      if(n ==0 || n == 1){
         return 1;
      } else {
         return n* fact(n-1);
      }
   }
}
