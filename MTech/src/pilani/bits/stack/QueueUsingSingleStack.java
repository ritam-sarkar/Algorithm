package pilani.bits.stack;

import java.util.Stack;

public class QueueUsingSingleStack {

   public static void main(String[] args) {

      MyQueue queue = new MyQueue();
      queue.enQueue(1);
      queue.enQueue(2);
      queue.enQueue(3);
      System.out.println(queue.deQueue());
      System.out.println(queue.deQueue());
      queue.enQueue(4);
      System.out.println(queue.deQueue());
      System.out.println(queue.deQueue());

   }
   private static class MyQueue {

      Stack<Integer> stack = new Stack<>();
      private void enQueue(int x){
         stack.push(x);
      }
      int deQueue(){
         reverse();
        int element =  stack.pop();
        reverse();
        return element;
      }

      private void reverse() {
         if(!stack.isEmpty()){
            int x = stack.pop();
            reverse();
            insertBottom(x);
         }
      }

      private void insertBottom(int x) {
         if(stack.isEmpty()){
            stack.push(x);
         } else{
            int y = stack.pop();
            insertBottom(x);
            stack.push(y);
         }
      }
   }

}
