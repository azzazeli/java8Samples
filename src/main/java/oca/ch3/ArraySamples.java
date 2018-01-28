package oca.ch3;

import java.util.Arrays;

public class ArraySamples {
    public static void main(String[] args) {
        ArraySamples samples = new ArraySamples();
        samples.testSorting();
        samples.testSearching();
        samples.testUnsortedArraySearch();
    }

    private void strangeDeclaration(){
        int var,array[];
    }

    private void inlineDeclaration(){
        String test[] = {"a", "b", "c"};
        String[] test1 = {"a", "b", "c"};
        String [] test2 = {"a", "b", "c"};
        String  []test3 = {"a", "b", "c"};
        String  test4[] = {"a", "b", "c"};
    }

    private void testSorting(){
        int[] test = {2,1,6,4};
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
    }

    private void testSearching(){
        int[]numbers = {2,4,6,8};
        System.out.println(Arrays.binarySearch(numbers,2));
        System.out.println(Arrays.binarySearch(numbers,4));
        System.out.println(Arrays.binarySearch(numbers,1));
        System.out.println(Arrays.binarySearch(numbers,3));
        System.out.println(Arrays.binarySearch(numbers,9));
    }

    private void testUnsortedArraySearch(){
        System.out.println("=========================");
        int[] numbers = {2,1,6,4};
        System.out.println(Arrays.binarySearch(numbers,2));
    }
}
