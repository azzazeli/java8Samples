package oca.ch3;

public class StringSamples {
    public static void main(String[] args) {
        StringSamples stringSamples = new StringSamples();
        stringSamples.subStringTest();
    }

    private void subStringTest(){
        String sample  = "sample";
        System.out.println(sample.substring(3,3));
//        System.out.println(sample.substring(3,2)); //StringIndexOutOfBoundException
//        System.out.println(sample.substring(3,8)); //StringIndexOutOfBoundException
    }
}
