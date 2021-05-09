package pilani.bits.stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
// Reverse the stack using push pop oparations only, do not use loop
public class StackReverese {

   static Stack<Integer> stack = new Stack<Integer>();

   public static void main(String[] args) {
     stack.push(1);
     stack.push(2);
     stack.push(3);
     stack.push(4);
     stack.push(5);
     reverse();
     while(!stack.isEmpty()){
        System.out.println(stack.pop());
     }
   }

   private static void reverse() {
      if(!stack.isEmpty()){

         int x = stack.pop();
         reverse();
         insertBottom(x);
      }
   }

   private static void insertBottom(int x) {
      if(stack.isEmpty()){
         stack.push(x);
      } else{
         int y = stack.pop();
         insertBottom(x);
         stack.push(y);
      }
   }
}
