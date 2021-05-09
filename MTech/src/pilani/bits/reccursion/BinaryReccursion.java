package pilani.bits.reccursion;

public class BinaryReccursion {
   public static void main(String[] args) {
      int n = 5;
      System.out.println("Number of binary digits "+binaryDigits(n));
   }

   private static int binaryDigits(int n) {

      if(n == 1){
         return 1;
      } else {
         return binaryDigits(n/2)+1;
      }

   }
}
