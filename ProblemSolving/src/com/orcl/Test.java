package com.orcl;

public class Test {
    public static void main(String[] args) {
       Parent o = new Child();
       o.sum(5);
       o.paint();

    }
    private static class Parent {
        int i;
        Parent(){
            sum(3);
        }
        void sum(int a){
            i += a;
        }
        void paint(){
            System.out.println(i);
        }
    }
    private static class Child extends Parent {
        Child(){
            sum(4);
        }
        void sum(int a){
           i += a*2;
        }
    }


}
