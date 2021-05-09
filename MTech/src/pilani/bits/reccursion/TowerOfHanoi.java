package pilani.bits.reccursion;

public class TowerOfHanoi {
   public static void main(String[] args) {

      toh(3,"A","B","C");
   }

   private static void toh(int n, String source, String aux, String dest){

      // one disk left
      if(n ==1){
         System.out.println("Move disk 1 from "+source+" to "+dest);
      } else {
         toh(n-1,source,dest, aux);
         System.out.println("Move disk "+ n +" from "+source+" to "+dest);
         toh(n-1,aux, source, dest);
      }
   }

}
