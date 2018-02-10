package oca.enthuware.sampletest;

public class TestDivideResult {
    public static void main(String[] args) throws Exception{
        int a =10;
        int b = a/10+2;
    }


    class A1 {
        public double m1(int a){
            return a*10/4-30;
        }
    }

    class A2 extends A1 {
        public double m1(int a){
            return a*10/4.0;
        }
    }
}
