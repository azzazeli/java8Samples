package oca.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PassByValue {

    private PassByValue() {
        System.out.println("PassByValue");
    }
    public static void main(String[] args) {
        PassByValue object =new PassByValue();
        List<String> list = Arrays.asList("1", "2", "3");
        System.out.println(list);
        object.objectRef(list);
        System.out.println(list);
        int x= 10;
        System.out.println("x=" + x);
        object.primitive(x);
        System.out.println("x=" + x);


        PassByValue passByValue = new PassByValue();
    }

    private void primitive(int x){
        x++;
        test();
    }

    public void test(){}


    private void objectRef(List<String> list){
        list = new ArrayList<>();
        list.add("1");
        list.add("2");
    }
}
